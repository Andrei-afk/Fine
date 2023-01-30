package com.example.fineproject.service;

import com.example.fineproject.mongo.document.IdentificationUserData;
import com.example.fineproject.mongo.document.User;
import com.example.fineproject.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class UserService implements UserRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private static final String USERS_COLLECTION = "users";
    private final MongoTemplate mongoTemplate;

    public UserService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void createUser(User user) {
        User getExistingUserWithUniqueEmail = mongoTemplate.findOne(new Query(
                        Criteria.where("username").is(String.valueOf(user.getUsername().hashCode()))),
                User.class,
                USERS_COLLECTION
        );
        if (getExistingUserWithUniqueEmail == null) {
            User getExistingUserWithUniquePNC = mongoTemplate.findOne(new Query(
                        Criteria.where("identificationUserData.personalNumericCode").is(String.valueOf(user.getIdentificationUserData().getPersonalNumericCode().hashCode()))),
                    User.class,
                    USERS_COLLECTION
            );
            if (getExistingUserWithUniquePNC == null) {
                mongoTemplate.insert(new User(
                        String.valueOf(user.getUsername().hashCode()),
                        String.valueOf(user.getPassword().hashCode()),
                        new IdentificationUserData(String.valueOf(user.getIdentificationUserData().getPersonalNumericCode().hashCode()),
                                String.valueOf(user.getIdentificationUserData().getSeries().hashCode()),
                                String.valueOf(user.getIdentificationUserData().getSeriesNumber().hashCode())),
                        user.isAdmin()), USERS_COLLECTION);
                LOGGER.info("Successfully created the user!");
            }
            else {
                LOGGER.info("A user with the same PNC already exists!");
                throw new IllegalArgumentException("A user with the same PNC already exists!");
            }
        } else {
            LOGGER.info("A user with the same username already exists!");
            throw new IllegalArgumentException("A user with the same username already exists!");
        }
    }

    @Override
    public User findByUsernameAndPassword(String username, String password, String personalNumericCode) throws AccountNotFoundException {
        Query query = new Query();
        query.addCriteria(
                Criteria.where("username").is(String.valueOf(username.hashCode()))
                        .andOperator(
                                Criteria.where("password").is(String.valueOf(password.hashCode())),
                                Criteria.where("identificationUserData.personalNumericCode")
                                .is(String.valueOf(personalNumericCode.hashCode())))
        );

        User getExistingUser = mongoTemplate.findOne(
                query,
                User.class,
                USERS_COLLECTION
        );
        if (getExistingUser != null) {
            LOGGER.info(String.format("User %s was found! ", username));
            return new User(username, password, new IdentificationUserData(personalNumericCode, null, null), getExistingUser.isAdmin());
        } else {
            throw new AccountNotFoundException();
        }
    }
}

package com.example.fineproject.service;

import com.example.fineproject.mongo.document.Fine;
import com.example.fineproject.mongo.document.User;
import com.example.fineproject.repository.FineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FineService implements FineRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private static final String FINES_COLLECTION = "fines";
    private static final String USERS_COLLECTION = "users";
    private final MongoTemplate mongoTemplate;

    public FineService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void createFine(Fine fine) {
        mongoTemplate.insert(new Fine(fine.getCar(), fine.getDateInformation(), fine.getFineAddress(),
                fine.getLaw(), fine.getPenalty(), fine.getPolicemanName(), fine.getDriverName(),
                fine.getIdentificationUserData(), fine.getDriverAddress()));
        LOGGER.info("Successfully created the fine!");
    }

    @Override
    public List<Fine> findFinesWithTheSamePNC(String username, String personalNumericCode) {
        Query query = new Query();
        List<Fine> fines = new ArrayList<>();
        query.addCriteria(
                Criteria.where("username").is(String.valueOf(username.hashCode()))
                        .andOperator(
                                Criteria.where("identificationUserData.personalNumericCode")
                                        .is(String.valueOf(personalNumericCode.hashCode())))
        );
        User getExistingUser = mongoTemplate.findOne(
                query, User.class, USERS_COLLECTION
        );
        if(getExistingUser != null) {
             fines = mongoTemplate.find(new Query(
                    Criteria.where("identificationUserData.personalNumericCode")
                            .is(personalNumericCode)),
                    Fine.class,
                    FINES_COLLECTION
            );
            LOGGER.info(String.format("Found %s fines linked to this user!", fines.size()));
        }
        else {
            LOGGER.error(String.format("This user %s does not exist!", username));
        }
        return fines;
    }
}

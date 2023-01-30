package com.example.fineproject.repository;

import com.example.fineproject.mongo.document.User;
import org.springframework.stereotype.Repository;

import javax.security.auth.login.AccountNotFoundException;

@Repository
public interface UserRepository {
    void createUser(User user);

    User findByUsernameAndPassword(String username, String password, String personalNumericCode) throws AccountNotFoundException;
}

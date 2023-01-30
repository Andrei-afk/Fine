package com.example.fineproject.mongo.document;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("users")
public class User implements Serializable {
    private String username;
    private String password;
    private IdentificationUserData identificationUserData;
    private boolean admin;

    @JsonCreator
    public User(String username, String password, IdentificationUserData identificationUserData, boolean admin) {
        this.username = username;
        this.password = password;
        this.identificationUserData = identificationUserData;
        this.admin = admin;
    }

    public User(String username, String password, IdentificationUserData identificationUserData) {
        this.username = username;
        this.password = password;
        this.identificationUserData = identificationUserData;
    }

    public User(String username, String password, boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    //mongo needs this
    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public IdentificationUserData getIdentificationUserData() {
        return identificationUserData;
    }

    public void setIdentificationUserData(IdentificationUserData identificationUserData) {
        this.identificationUserData = identificationUserData;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identificationUserData=" + identificationUserData +
                ", admin=" + admin +
                '}';
    }
}

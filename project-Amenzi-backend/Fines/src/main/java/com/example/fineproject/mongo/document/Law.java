package com.example.fineproject.mongo.document;

public class Law {
    private String lawNumber;
    private String lawDescription;

    public Law(String lawNumber, String lawDescription) {
        this.lawNumber = lawNumber;
        this.lawDescription = lawDescription;
    }

    public String getLawNumber() {
        return lawNumber;
    }

    public void setLawNumber(String lawNumber) {
        this.lawNumber = lawNumber;
    }

    public String getLawDescription() {
        return lawDescription;
    }

    public void setLawDescription(String lawDescription) {
        this.lawDescription = lawDescription;
    }

    @Override
    public String toString() {
        return "Law{" +
                "lawNumber='" + lawNumber + '\'' +
                ", lawDescription='" + lawDescription + '\'' +
                '}';
    }
}

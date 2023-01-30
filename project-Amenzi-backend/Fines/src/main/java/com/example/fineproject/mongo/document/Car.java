package com.example.fineproject.mongo.document;

public class Car {
    private String carCompany;
    private String colour;
    private String licensePlate;

    public Car(String carCompany, String colour, String licensePlate) {
        this.carCompany = carCompany;
        this.colour = colour;
        this.licensePlate = licensePlate;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carCompany='" + carCompany + '\'' +
                ", colour='" + colour + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}

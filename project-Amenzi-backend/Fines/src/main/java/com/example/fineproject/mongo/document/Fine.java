package com.example.fineproject.mongo.document;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("fines")
public class Fine {
    //nr crt = _id
    @Field("_id")
    private String _id;
    private Car car;
    private DateInformation dateInformation;
    private Address fineAddress;
    private Law law;
    private Penalty penalty;
    private String policemanName;
    private String driverName;
    private IdentificationUserData identificationUserData;
    private Address driverAddress;

    public Fine(Car car, DateInformation dateInformation, Address fineAddress,
                Law law, Penalty penalty, String policemanName,
                String driverName, IdentificationUserData identificationUserData, Address driverAddress) {
        this.car = car;
        this.dateInformation = dateInformation;
        this.fineAddress = fineAddress;
        this.law = law;
        this.penalty = penalty;
        this.policemanName = policemanName;
        this.driverName = driverName;
        this.identificationUserData = identificationUserData;
        this.driverAddress = driverAddress;
    }

    public Fine() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public DateInformation getDateInformation() {
        return dateInformation;
    }

    public void setDateInformation(DateInformation dateInformation) {
        this.dateInformation = dateInformation;
    }

    public Address getFineAddress() {
        return fineAddress;
    }

    public void setFineAddress(Address fineAddress) {
        this.fineAddress = fineAddress;
    }

    public Law getLaw() {
        return law;
    }

    public void setLaw(Law law) {
        this.law = law;
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    public String getPolicemanName() {
        return policemanName;
    }

    public void setPolicemanName(String policemanName) {
        this.policemanName = policemanName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public IdentificationUserData getIdentificationUserData() {
        return identificationUserData;
    }

    public void setIdentificationUserData(IdentificationUserData identificationUserData) {
        this.identificationUserData = identificationUserData;
    }

    public Address getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(Address driverAddress) {
        this.driverAddress = driverAddress;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "_id=" + _id +
                ", car=" + car +
                ", dateInformation=" + dateInformation +
                ", fineAddress=" + fineAddress +
                ", law=" + law +
                ", penalty=" + penalty +
                ", policemanName='" + policemanName + '\'' +
                ", driverName='" + driverName + '\'' +
                ", identificationUserData=" + identificationUserData +
                ", driverAddress=" + driverAddress +
                '}';
    }
}

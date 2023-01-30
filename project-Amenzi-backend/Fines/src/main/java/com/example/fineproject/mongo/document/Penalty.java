package com.example.fineproject.mongo.document;

public class Penalty {
    private String fineAmount;
    private String pointsDeducted;

    public Penalty(String fineAmount, String pointsDeducted) {
        this.fineAmount = fineAmount;
        this.pointsDeducted = pointsDeducted;
    }

    public String getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(String fineAmount) {
        this.fineAmount = fineAmount;
    }

    public String getPointsDeducted() {
        return pointsDeducted;
    }

    public void setPointsDeducted(String pointsDeducted) {
        this.pointsDeducted = pointsDeducted;
    }

    @Override
    public String toString() {
        return "Penalty{" +
                "fineAmount='" + fineAmount + '\'' +
                ", pointsDeducted='" + pointsDeducted + '\'' +
                '}';
    }
}

package com.example.fineproject.mongo.document;

public class IdentificationUserData {
    public String personalNumericCode;
    public String series;
    public String seriesNumber;

    public IdentificationUserData(String personalNumericCode, String series, String seriesNumber) {
        this.personalNumericCode = personalNumericCode;
        this.series = series;
        this.seriesNumber = seriesNumber;
    }

    public String getPersonalNumericCode() {
        return personalNumericCode;
    }

    public void setPersonalNumericCode(String personalNumericCode) {
        this.personalNumericCode = personalNumericCode;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    @Override
    public String toString() {
        return "IdentificationUserData{" +
                "personalNumericCode='" + personalNumericCode + '\'' +
                ", series='" + series + '\'' +
                ", seriesNumber='" + seriesNumber + '\'' +
                '}';
    }
}

package com.example.fineproject.mongo.document;

public class DateInformation {
    private String calendarDate;
    private String dayDateStart;
    private String dayDateFinish;

    public DateInformation(String calendarDate, String dayDateStart, String dayDateFinish) {
        this.calendarDate = calendarDate;
        this.dayDateStart = dayDateStart;
        this.dayDateFinish = dayDateFinish;
    }

    public String getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(String calendarDate) {
        this.calendarDate = calendarDate;
    }

    public String getDayDateStart() {
        return dayDateStart;
    }

    public void setDayDateStart(String dayDateStart) {
        this.dayDateStart = dayDateStart;
    }

    public String getDayDateFinish() {
        return dayDateFinish;
    }

    public void setDayDateFinish(String dayDateFinish) {
        this.dayDateFinish = dayDateFinish;
    }

    @Override
    public String toString() {
        return "DateInformation{" +
                "calendarDate='" + calendarDate + '\'' +
                ", dayDateStart='" + dayDateStart + '\'' +
                ", dayDateFinish='" + dayDateFinish + '\'' +
                '}';
    }
}

package com.example.rhythym_guard;

public class MainModel {
    String comment, date, diastolic_pressure, heart_rate, systolic_pressure,time;

    MainModel()
    {

    }

    public String getComment() {
        return comment;
    }

    public MainModel(String comment, String date, String diastolic_pressure, String heart_rate, String systolic_pressure, String time) {
        this.comment = comment;
        this.date = date;
        this.diastolic_pressure = diastolic_pressure;
        this.heart_rate = heart_rate;
        this.systolic_pressure = systolic_pressure;
        this.time = time;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiastolic_pressure() {
        return diastolic_pressure;
    }

    public void setDiastolic_pressure(String diastolic_pressure) {
        this.diastolic_pressure = diastolic_pressure;
    }

    public String getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(String heart_rate) {
        this.heart_rate = heart_rate;
    }

    public String getSystolic_pressure() {
        return systolic_pressure;
    }

    public void setSystolic_pressure(String systolic_pressure) {
        this.systolic_pressure = systolic_pressure;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}


package com.example.rhythym_guard;

/**
 * this class is used to get and set data
 */

public class MainModel {
    String comment, date, diastolic_pressure, heart_rate, systolic_pressure,time;

    MainModel()
    {

    }

    /**
     * returns comment
     * @return
     */

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

    /**
     * sets comment on database
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     */

    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     */

    public String getDiastolic_pressure() {
        return diastolic_pressure;
    }

    /**
     *
     * @param diastolic_pressure
     */

    public void setDiastolic_pressure(String diastolic_pressure) {
        this.diastolic_pressure = diastolic_pressure;
    }

    /**
     *
     * @return
     */

    public String getHeart_rate() {
        return heart_rate;
    }

    /**
     *
     * @param heart_rate
     */

    public void setHeart_rate(String heart_rate) {
        this.heart_rate = heart_rate;
    }

    /**
     *
     * @return
     */
    public String getSystolic_pressure() {
        return systolic_pressure;
    }

    /**
     *
     * @param systolic_pressure
     */

    public void setSystolic_pressure(String systolic_pressure) {
        this.systolic_pressure = systolic_pressure;
    }

    /**
     * returns time
     * @return
     */

    public String getTime() {
        return time;
    }

    /**
     * sets time in db
     * @param time
     */

    public void setTime(String time) {
        this.time = time;
    }
}


package com.example.rhythym_guard;
import org.junit.Test;

import static org.junit.Assert.*;
public class Unit_Test {
    @Test
    public void getCommentTest(){
        MainModel mainModel=new MainModel("good","21-03-2023","120","75","80","5.00");
        assertEquals("good",mainModel.getComment());
    }

    @Test
    public void getDateTest(){
        MainModel mainModel=new MainModel("good","21-03-2023","120","75","80","5.00");
        assertEquals("21-03-2023",mainModel.getDate());
    }

    @Test
    public void getDiastolicTest(){
        MainModel mainModel=new MainModel("good","21-03-2023","120","75","80","5.00");
        assertEquals("120",mainModel.getDiastolic_pressure());
    }

    @Test
    public void getHeartRateTest(){
        MainModel mainModel=new MainModel("good","21-03-2023","120","75","80","5.00");
        assertEquals("75",mainModel.getHeart_rate());
    }

    @Test
    public void getSystolicTest(){
        MainModel mainModel=new MainModel("good","21-03-2023","120","75","80","5.00");
        assertEquals("80",mainModel.getSystolic_pressure());
    }

    @Test
    public void getTimeTest(){
        MainModel mainModel=new MainModel("good","21-03-2023","120","98","130","5.00");
        assertEquals("5.00",mainModel.getTime());
    }

    @Test
    public void setCommentTest() {
        MainModel mainModel = new MainModel();
        mainModel.setComment("good");
        assertEquals("good", mainModel.getComment());
    }

    @Test
    public void setDateTest() {
        MainModel mainModel = new MainModel();
        mainModel.setDate("21-03-2023");
        assertEquals("21-03-2023", mainModel.getDate());
    }

    @Test
    public void setDiastolicPressureTest() {
        MainModel mainModel = new MainModel();
        mainModel.setDiastolic_pressure("120");
        assertEquals("120", mainModel.getDiastolic_pressure());
    }

    @Test
    public void setHeartRateTest() {
        MainModel mainModel = new MainModel();
        mainModel.setHeart_rate("98");
        assertEquals("98", mainModel.getHeart_rate());
    }

    @Test
    public void setSystolicPressureTest() {
        MainModel mainModel = new MainModel();
        mainModel.setSystolic_pressure("130");
        assertEquals("130", mainModel.getSystolic_pressure());
    }

    @Test
    public void setTimeTest() {
        MainModel mainModel = new MainModel();
        mainModel.setTime("5.00");
        assertEquals("5.00", mainModel.getTime());
    }

}

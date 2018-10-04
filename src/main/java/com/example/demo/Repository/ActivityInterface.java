package com.example.demo.Repository;

import java.sql.SQLException;
import com.example.demo.Model.Activity;

import java.util.Date;
import java.util.List;

public interface ActivityInterface {

    List<Activity> readAll();

    int getActivityListSize();

    void OpretAktivitet (String name,int ageLimit, int slots, String location) throws SQLException;

    void RedigerAktivitet(int ActivityID, String name, int AgeLimit, int Slots, String Location) throws SQLException;

    Activity LæsAktivitet(int id);
}



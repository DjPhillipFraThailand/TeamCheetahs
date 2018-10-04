package com.example.demo.Repository;

import java.sql.SQLException;
import com.example.demo.Model.Activity;

import java.util.Date;
import java.util.List;

public interface ActivityInterface {

    List<Activity> readAll();

    int getActivityListSize();

    void OpretAktivitet(String name, int agelimit, int slots, String location, Date date, int participants) throws SQLException;

    void RedigerAktivitet(Activity activity) throws SQLException;

    Activity LæsAktivitet(int id);
}



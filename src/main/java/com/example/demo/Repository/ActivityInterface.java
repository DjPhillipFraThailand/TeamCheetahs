package com.example.demo.Repository;

import java.sql.SQLException;
import com.example.demo.Model.Activity;

import java.time.LocalDateTime;
import java.util.List;

public interface ActivityInterface {

    List<Activity> readAll();

    int getActivityListSize();

    void OpretAktivitet(String name, int agelimit, int slots, String location, int participants) throws SQLException;


    void RedigerAktivitet(Activity activity);

    Activity LæsAktivitet(int id);
}



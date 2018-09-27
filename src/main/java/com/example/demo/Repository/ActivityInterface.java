package com.example.demo.Repository;

import com.example.demo.Model.Activity;

<<<<<<< HEAD
import java.sql.SQLException;
import java.util.List;

public interface ActivityInterface {

    List<Activity> readAll();

    Activity OpretAktivitet(Activity activity);

import java.sql.SQLException;

public interface ActivityInterface {

    boolean OpretAktivitet(Activity activity) throws SQLException;


    void RedigerAktivitet(Activity activity);

    Activity LæsAktivitet(int id);

}

package com.example.demo.Repository;

import java.sql.SQLException;
import com.example.demo.Model.Activity;

import java.util.List;

public interface ActivityInterface {

    List<Activity> readAll();


    boolean OpretAktivitet(Activity activity) throws SQLException;


    void RedigerAktivitet(Activity activity);

    Activity LæsAktivitet(int id);
}



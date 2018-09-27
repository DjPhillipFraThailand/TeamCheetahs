package com.example.demo.Repository;

import com.example.demo.Model.Activity;

import java.util.List;

public interface ActivityInterface {

    List<Activity> readAll();

    Activity OpretAktivitet(Activity activity);

    void RedigerAktivitet(Activity activity);

    Activity LæsAktivitet(int id);

}

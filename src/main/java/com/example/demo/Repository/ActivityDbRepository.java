package com.example.demo.Repository;

import com.example.demo.Model.Activity;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityDbRepository implements ActivityInterface{

    @Override
    public Activity OpretAktivitet(Activity activity) {
        return activity;

    }

    @Override
    public void RedigerAktivitet(Activity activity) {

    }

    @Override
    public Activity LæsAktivitet(int id) {
        return null;
    }
}

package com.example.demo.Repository;

import com.example.demo.Model.Activity;

public interface ActivityInterface {

    boolean OpretAktivitet(Activity activity);

    void RedigerAktivitet(Activity activity);

    Activity LæsAktivitet(int id);

}

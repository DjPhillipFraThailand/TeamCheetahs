package com.example.demo.Repository;

import com.example.demo.Model.Activity;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.time.LocalDateTime;

public interface ActivityInterface {

    boolean OpretAktivitet(Activity activity);

    void RedigerAktivitet(Activity activity);

    Activity LæsAktivitet(int id);

}

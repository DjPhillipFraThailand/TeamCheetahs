package com.example.demo.Repository;

import com.example.demo.Model.Activity;

import java.sql.SQLException;

public interface ActivityInterface {

    boolean OpretAktivitet(Activity activity) throws SQLException;

    void RedigerAktivitet(Activity activity);

    Activity LæsAktivitet(int id);

}

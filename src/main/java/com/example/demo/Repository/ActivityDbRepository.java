package com.example.demo.Repository;

import com.example.demo.Model.Activity;
import com.sun.tools.jdeprscan.scan.Scan;
import org.springframework.stereotype.Repository;


import java.util.Scanner;

import java.time.LocalDateTime;


@Repository
public class ActivityDbRepository implements ActivityInterface {

    @Override

    public boolean OpretAktivitet(Activity activity) {
        String sqlString = "INSERT INTO Activity (Activity_Name, Activity_AgeLimit, Activity_Slots, Activity_DateTime, Activity_Number_of_participants) VALUES "+
                "('"+activity.getNavn()+"', '"+activity.getAgeLimit()+"')";
        //ResultSet = DBconn.dbquery(sqlString);

        /*if (ResultSet) {
            return true;
        } else {
            return false;
        }*/
        return true;

    }

    @Override
    public void RedigerAktivitet(Activity activity) {

    }

    @Override
    public Activity LæsAktivitet(int id) {
        return null;
    }
}

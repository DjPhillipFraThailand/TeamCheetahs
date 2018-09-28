package com.example.demo.Repository;

import com.example.demo.Model.Activity;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;
import java.time.LocalDateTime;

import static com.example.demo.Control.AdventureXPController.DBconn;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActivityDbRepository implements ActivityInterface {

    private List<Activity> activityList;

    public ActivityDbRepository() {
        activityList = new ArrayList<>();

    }

    @Override
    public List<Activity> readAll() {
        return activityList;
    }

    @Override
    public boolean OpretAktivitet(Activity activity) throws SQLException {
        String sqlString = "INSERT INTO Activity (Activity_Name, Activity_AgeLimit, Activity_Slots, Activity_DateTime, Activity_Number_of_participants) VALUES " +
                "('" + activity.getNavn() + "', '" + activity.getAgeLimit() + "')";
        ResultSet resultset = DBconn.dbQuery(sqlString);

        if (resultset.rowInserted()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void RedigerAktivitet(Activity activity) {
        activityList.remove(activity.getId() - 1);
        activityList.add(activity);


//        jdbc.update("UPDATE AdventureDb.activities SET " +
//                "name ='" + activity.getNavn() + "' , " +
//                "age_limit ='" + activity.getAgeLimit() + "' , " +
//                "pladser ='" + activity.getPladser() + "' , " +
//                "sted ='" + activity.getSted() + "' , " +
//                "date_time ='" + activity.getDateTime() + "' , " +
//                "antal ='" + activity.getAntal() + "' WHERE activities_id = '" + activity.getId() + "'");


    }

    @Override
    public Activity LæsAktivitet(int id) {
        return null;
    }
}

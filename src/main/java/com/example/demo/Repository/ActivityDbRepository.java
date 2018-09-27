package com.example.demo.Repository;

import com.example.demo.Model.Activity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActivityDbRepository implements ActivityInterface{


    private List<Activity> activityList;

    public ActivityDbRepository(){
        activityList = new ArrayList<>();

    }

    @Override
    public List<Activity> readAll() {
        return activityList;
    }

    @Override
    public Activity OpretAktivitet(Activity activity) {
        return activity;

    }

    @Override
    public void RedigerAktivitet(Activity activity) {
        activityList.remove(activity.getId()-1);
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

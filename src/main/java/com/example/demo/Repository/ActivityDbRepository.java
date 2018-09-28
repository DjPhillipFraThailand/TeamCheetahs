package com.example.demo.Repository;

import com.example.demo.Model.Activity;
import org.apache.tomcat.jni.Local;
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

    public ActivityDbRepository(){
        activityList = new ArrayList<>();

    }

    @Override
    public List<Activity> readAll() {
        return activityList;
    }

    @Override
    public int getActivityListSize() { return activityList.size(); }

    @Override
    public boolean OpretAktivitet(String name, int ageLimit, int slots, String location, LocalDateTime datestamp, int participants) throws SQLException {
        name = DBconn.res(name);
        location = DBconn.res(location);

        String createActivitySql =  "INSERT INTO "+DBconn.DBprefix+"Activities (Activity_Name, Activity_AgeLimit, Activity_Slots, Activity_Location, Activity_DateTime, Activity_NumOfParticipants) " +
                "VALUES ('"+name+"', '"+ageLimit+"', '"+slots+"', '"+location+"', '"+datestamp+"', '"+participants+"');";
        ResultSet resultset = DBconn.dbQuery(createActivitySql);

        if (resultset.rowInserted()) {
            this.activityList.add(new Activity(this.getActivityListSize()+1, name, ageLimit, slots, location, datestamp, participants));
            return true;
        } else {
            return false;
        }
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

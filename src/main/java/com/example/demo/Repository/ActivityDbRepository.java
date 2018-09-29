package com.example.demo.Repository;

import com.example.demo.Model.Activity;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;


import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import static com.example.demo.Control.AdventureXPController.DBconn;


import java.util.ArrayList;
import java.util.List;

@Repository
public class ActivityDbRepository implements ActivityInterface {


    private List<Activity> activityList;

    public ActivityDbRepository() throws SQLException {
        activityList = new ArrayList<>();
        String ActivitySql = "SELECT * FROM "+DBconn.DBprefix+"Activities ORDER BY Activity_ID ASC";
        ResultSet ActivityQuery = DBconn.dbQuery(ActivitySql);
        while (ActivityQuery.next()) {
            activityList.add(new Activity(
                    ActivityQuery.getInt("Activity_ID"),
                    ActivityQuery.getString("Activity_Name"),
                    ActivityQuery.getInt("Activity_AgeLimit"),
                    ActivityQuery.getInt("Activity_Slots"),
                    ActivityQuery.getString("Activity_Location"),
                    ActivityQuery.getString("Activity_DateTime"),
                    ActivityQuery.getInt("Activity_NumOfParticipants")
            ));
        }
    }

    @Override
    public List<Activity> readAll() {
        return activityList;
    }

    @Override
    public int getActivityListSize() { return activityList.size(); }

    @Override
    public void OpretAktivitet(String name, int ageLimit, int slots, String location, int participants) throws SQLException {
        name = DBconn.res(name);
        location = DBconn.res(location);

        String datestamp = LocalDateTime.now().toString();

        String createActivitySql =  "INSERT INTO "+DBconn.DBprefix+"Activities (Activity_Name, Activity_AgeLimit, Activity_Slots, Activity_Location, Activity_DateTime, Activity_NumOfParticipants) " +
                "VALUES ('"+name+"', '"+ageLimit+"', '"+slots+"', '"+location+"', '"+datestamp+"', '"+participants+"');";
        DBconn.dbUpdate(createActivitySql);
        this.activityList.add(new Activity(this.getActivityListSize()+1, name, ageLimit, slots, location, datestamp, participants));
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

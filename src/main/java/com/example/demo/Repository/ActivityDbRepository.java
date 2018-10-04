package com.example.demo.Repository;

import com.example.demo.Model.Activity;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import static com.example.demo.Control.AdventureXPController.DBconn;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ActivityDbRepository implements ActivityInterface {

    private List<Activity> activityList;

    public ActivityDbRepository() throws SQLException {
        activityList = new ArrayList<>();

        String selectSQL = "SELECT * FROM " + DBconn.DBprefix + "Activities ORDER BY Activity_ID ASC";
        PreparedStatement preparedStatement = DBconn.DBconnect.prepareStatement(selectSQL);
        ResultSet ActivityQuery = DBconn.statementQuery(preparedStatement);

        while (ActivityQuery.next()) {
            activityList.add(new Activity(
                    ActivityQuery.getInt("Activity_ID"),
                    ActivityQuery.getString("Activity_Name"),
                    ActivityQuery.getInt("Activity_AgeLimit"),
                    ActivityQuery.getInt("Activity_Slots"),
                    ActivityQuery.getString("Activity_Location"),
                    ActivityQuery.getDate("Activity_DateTime"),
                    ActivityQuery.getInt("Activity_NumOfParticipants")
            ));
            System.out.println(ActivityQuery.getString("Activity_Name"));
        }
    }

    @Override
    public List<Activity> readAll() {
        return activityList;
    }

    @Override
    public int getActivityListSize() {
        return 0;
    }

    @Override
    public void OpretAktivitet(String name, int agelimit, int slots, String location, Date date, int participants) throws SQLException {

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
    public int RedigerAktivitet(Activity activity) {
        activityList.remove(activity.getId() - 1);
        activityList.add(activity);

//        jdbc.update("UPDATE AdventureDb.activities SET " +
//                "name ='" + activity.getNavn() + "' , " +
//                "age_limit ='" + activity.getAgeLimit() + "' , " +
//                "pladser ='" + activity.getPladser() + "' , " +
//                "sted ='" + activity.getSted() + "' , " +
//                "date_time ='" + activity.getDateTime() + "' , " +
//                "antal ='" + activity.getAntal() + "' WHERE activities_id = '" + activity.getId() + "'");

        public int getActivityListSize () {
            return activityList.size();
        }

        @Override
        public void OpretAktivitet (String name,int ageLimit, int slots, String location, Date date,int participants) throws SQLException {
            name = DBconn.res(name);
            location = DBconn.res(location);

            Date datestamp = new java.sql.Date(new Date().getTime());

            String insertSQL = "INSERT INTO " + DBconn.DBprefix + "Activities (Activity_Name, Activity_AgeLimit, Activity_Slots, Activity_Location, Activity_DateTime, Activity_NumOfParticipants) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pStatement = DBconn.DBconnect.prepareStatement(insertSQL);
            pStatement.setString(1, name);
            pStatement.setInt(2, ageLimit);
            pStatement.setInt(3, slots);
            pStatement.setString(4, location);
            pStatement.setDate(5, (java.sql.Date) datestamp);
            pStatement.setInt(6, participants);
            DBconn.statementUpdate(pStatement);
            this.activityList.add(new Activity(this.getActivityListSize() + 1, name, ageLimit, slots, location, datestamp, participants));
        }

        @Override
        public void RedigerAktivitet (Activity activity) throws SQLException {
            activityList.remove(activity.getId() - 1);
            activityList.add(activity);

            String updateActivitySQL = "UPDATE " + DBconn.DBprefix + " SET Activity_Name = ?, Activity_AgeLimit = ?, Activity_Slots = ?, Activity_Location = ?, Activity_DateTime = ?, Activity_NumOfParticipants = ? WHERE Activity_ID = ?";
            PreparedStatement pStatement = DBconn.DBconnect.prepareStatement(updateActivitySQL);
            pStatement.setString(1, activity.getNavn());
            pStatement.setInt(2, activity.getAgeLimit());
            pStatement.setInt(3, activity.getPladser());
            pStatement.setString(4, activity.getSted());
            pStatement.setDate(5, (java.sql.Date) activity.getDateTime());
            pStatement.setInt(6, activity.getAntal());
            pStatement.setInt(7, activity.getId());
            DBconn.statementUpdate(pStatement);
        }

        @Override
        public Activity LæsAktivitet ( int id){

            return activityList.get(id);

        }
    }

    @Override
    public Activity LæsAktivitet(int id) {
        return null;
    }
}
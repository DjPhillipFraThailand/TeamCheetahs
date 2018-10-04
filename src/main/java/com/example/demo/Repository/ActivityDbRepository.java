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
                    ActivityQuery.getString("Activity_Location")
            ));
        }
    }

    @Override
    public List<Activity> readAll() {
        return activityList;
    }

    @Override
    public int getActivityListSize() {
        return activityList.size();
    }

    @Override
    public void OpretAktivitet (String name,int ageLimit, int slots, String location) throws SQLException {
        name = DBconn.res(name);
        location = DBconn.res(location);

        String insertSQL = "INSERT INTO " + DBconn.DBprefix + "Activities (Activity_Name, Activity_AgeLimit, Activity_Slots, Activity_Location, Activity_DateTime, Activity_NumOfParticipants) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pStatement = DBconn.DBconnect.prepareStatement(insertSQL);
        pStatement.setString(1, name);
        pStatement.setInt(2, ageLimit);
        pStatement.setInt(3, slots);
        pStatement.setString(4, location);
        DBconn.statementUpdate(pStatement);
        this.activityList.add(new Activity(this.getActivityListSize() + 1, name, ageLimit, slots, location));
    }

    @Override
    public void RedigerAktivitet(int ActivityID, String name, int AgeLimit, int Slots, String Location) throws SQLException {
        Activity temp = activityList.get(ActivityID-1);

        String updateActivitySQL = "UPDATE " + DBconn.DBprefix + " SET Activity_Name = ?, Activity_AgeLimit = ?, Activity_Slots = ?, Activity_Location = ? WHERE Activity_ID = ?";
        PreparedStatement pStatement = DBconn.DBconnect.prepareStatement(updateActivitySQL);
        pStatement.setString(1, temp.getNavn());
        pStatement.setInt(2, temp.getAgeLimit());
        pStatement.setInt(3, temp.getPladser());
        pStatement.setString(4, temp.getSted());
        pStatement.setInt(5, temp.getId());

        DBconn.statementUpdate(pStatement);
        activityList.set(ActivityID-1, temp);
    }

    @Override
    public Activity LæsAktivitet(int id){
        return activityList.get(id);
    }
}
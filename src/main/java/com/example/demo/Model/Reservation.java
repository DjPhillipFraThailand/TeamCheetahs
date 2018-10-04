package com.example.demo.Model;

import com.example.demo.Repository.ActivityDbRepository;

import java.util.List;

public class Reservation {

    private int id;

    private Activity activity = new Activity();


    /*@Override
    public String toString() {
        return "Reservation " +
                "[id: " + id +
                ", navn: " + navn +
                ", ageLimit: " + ageLimit +
                ", pladser: " + pladser +
                ", sted: " + sted +
                ", dateTime: " + dateTime +
                ", antal: " + antal + "]";
    }*/

    public Reservation(int id, int activityId){

        this.id = id;
        activityId = activity.getId();


    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }
}

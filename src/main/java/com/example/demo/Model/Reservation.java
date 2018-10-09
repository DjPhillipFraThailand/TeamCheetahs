package com.example.demo.Model;

import com.example.demo.Repository.ActivityDbRepository;

import java.util.Date;
import java.util.List;

public class Reservation {

    private int reservationId;
    private String reservationName;
    private Date reservationDate;
    private String reservationTimestamp;
    private int reservationAmount;
    private int activityID;


    public Reservation(){

    }

    public Reservation(int reservationId, int activityID, String reservationName, Date reservationDate, String reservationTimestamp, int reservationAmount) {
        this.reservationId = reservationId;
        this.activityID = activityID;
        this.reservationName = reservationName;
        this.reservationDate = reservationDate;
        this.reservationTimestamp = reservationTimestamp;
        this.reservationAmount = reservationAmount;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationTimestamp() {
        return reservationTimestamp;
    }

    public void setReservationTimestamp(String reservationTimestamp) {
        this.reservationTimestamp = reservationTimestamp;
    }

    public int getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(int reservationAmount) {
        this.reservationAmount = reservationAmount;
    }
}

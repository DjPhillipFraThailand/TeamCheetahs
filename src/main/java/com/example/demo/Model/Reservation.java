package com.example.demo.Model;

import com.example.demo.Repository.ActivityDbRepository;

import java.util.Date;
import java.util.List;

public class Reservation {

    private int reservationId;
    private String reservationName;
    private Date reservationDate;
    private int reservationAmount;


    public Reservation(){

    }

    public Reservation(int reservationId, String reservationName, Date reservationDate, int reservationAmount) {
        this.reservationId = reservationId;
        this.reservationName = reservationName;
        this.reservationDate = reservationDate;
        this.reservationAmount = reservationAmount;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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

    public int getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(int reservationAmount) {
        this.reservationAmount = reservationAmount;
    }
}

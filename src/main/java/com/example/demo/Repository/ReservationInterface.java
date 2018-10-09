package com.example.demo.Repository;

import com.example.demo.Model.Reservation;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ReservationInterface {

    public int getReservationListSize();

    public void OpretReservation(String reservationName, Date reservationDate, String reservationTimestamp, int reservationAmount, int ActivityID) throws SQLException;

    public List<Reservation> getReservations(int ActivityID);

    public List<Reservation> getAll();
}

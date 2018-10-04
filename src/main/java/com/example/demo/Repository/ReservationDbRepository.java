package com.example.demo.Repository;

import com.example.demo.Model.Reservation;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static com.example.demo.Control.AdventureXPController.DBconn;

@Repository
public class ReservationDbRepository {

    private List<Reservation> reservationList;

    public void OpretReservation(String reservationName, Date reservationDate, int reservationAmount) throws SQLException {
        reservationName = DBconn.res(reservationName);

        String insertSql = "INSERT INTO" + DBconn.DBprefix + "Reservation (Reservation_amount, Reservation_Date, Reservation_Name) VALUES (?,?,?)";
        PreparedStatement pStatement = DBconn.DBconnect.prepareStatement(insertSql);
        pStatement.setInt(1, reservationAmount);
        pStatement.setDate(2, (java.sql.Date) reservationDate);
        pStatement.setString(3,  reservationName);
        DBconn.statementUpdate(pStatement);
        this.reservationList.add(new Reservation(1, reservationName, reservationDate, reservationAmount));
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }
}

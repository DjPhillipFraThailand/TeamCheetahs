package com.example.demo.Repository;

import com.example.demo.Model.Reservation;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo.Control.AdventureXPController.DBconn;

@Repository
public class ReservationDbRepository implements ReservationInterface {

    private List<Reservation> reservationList;

    public ReservationDbRepository() throws SQLException {
        reservationList = new ArrayList<>();

        String selectSQL = "SELECT * FROM " + DBconn.DBprefix + "Reservation ORDER BY Reservation_ID ASC";
        PreparedStatement preparedStatement = DBconn.DBconnect.prepareStatement(selectSQL);
        ResultSet ReservationQuery = DBconn.statementQuery(preparedStatement);

        while (ReservationQuery.next()) {
            reservationList.add(new Reservation(
                    ReservationQuery.getInt("Reservation_ID"),
                    ReservationQuery.getInt("Activity_fkID"),
                    ReservationQuery.getString("Reservation_Name"),
                    ReservationQuery.getString("Reservation_Phone"),
                    ReservationQuery.getDate("Reservation_Date"),
                    ReservationQuery.getString("Reservation_Timestamp"),
                    ReservationQuery.getInt("Reservation_Amount")
            ));
        }
    }

    public int getReservationListSize() {
        return reservationList.size();
    }

    public List<Reservation> getReservations(int ActivityID) {
        List<Reservation> temp = new ArrayList<>();
        for (Reservation R : reservationList) {
            if (R.getActivityID() == ActivityID) {
                temp.add(new Reservation(
                        R.getReservationId(),
                        R.getActivityID(),
                        R.getReservationName(),
                        R.getReservationPhone(),
                        R.getReservationDate(),
                        R.getReservationTimestamp(),
                        R.getReservationAmount()
                ));
            }
        }
        return temp;
    }

    public void OpretReservation(String reservationName, String reservationPhone, Date reservationDate, String reservationTimestamp, int reservationAmount, int ActivityID) throws SQLException {
        reservationName = DBconn.res(reservationName);
        reservationPhone = DBconn.res(reservationPhone);
        reservationTimestamp = DBconn.res(reservationTimestamp);
        java.sql.Date datestamp = new java.sql.Date(reservationDate.getTime());

        String insertSql = "INSERT INTO "+DBconn.DBprefix+"Reservation (Reservation_Amount, Reservation_Date, Reservation_Timestamp, Reservation_Name, Reservation_Phone, Activity_fkID) VALUES (?,?,?,?,?,?)";

        PreparedStatement pStatement = DBconn.DBconnect.prepareStatement(insertSql);
        pStatement.setInt(1, reservationAmount);
        pStatement.setString(2, datestamp.toString());
        pStatement.setString(3, reservationTimestamp);
        pStatement.setString(4,  reservationName);
        pStatement.setString(5, reservationPhone);
        pStatement.setInt(6, ActivityID);
        DBconn.statementUpdate(pStatement);
        this.reservationList.add(new Reservation(this.getReservationListSize() + 1, ActivityID, reservationName, reservationPhone, datestamp, reservationTimestamp, reservationAmount));
    }

    public List<Reservation> getAll() {
        return reservationList;
    }
}

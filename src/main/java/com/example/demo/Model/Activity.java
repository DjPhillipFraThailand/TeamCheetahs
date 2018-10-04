package com.example.demo.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class Activity {
    private int id;
    private String navn;
    private int ageLimit;
    private int pladser;
    private String sted;
    private Date dateTime;
    private int antal;

    @Override
    public String toString() {
        return "Activity " +
                "[id: " + id +
                ", navn: " + navn +
                ", ageLimit: " + ageLimit +
                ", pladser: " + pladser +
                ", sted: " + sted +
                ", dateTime: " + dateTime +
                ", antal: " + antal + "]";
    }

    public Activity(int id, String navn, int ageLimit, int pladser, String sted, Date dateTime, int antal) {
        this.id = id;
        this.navn = navn;
        this.ageLimit = ageLimit;
        this.pladser = pladser;
        this.sted = sted;
       // this.dateTime = dateTime;
        this.antal = antal;

    }

    public Activity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getPladser() {
        return pladser;
    }

    public void setPladser(int pladser) {
        this.pladser = pladser;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    }


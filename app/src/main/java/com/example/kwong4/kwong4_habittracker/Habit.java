package com.example.kwong4.kwong4_habittracker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Wookiez on 9/28/2016.
 */
public class Habit {
    private Date date;
    private String name;
    private ArrayList repeatDays;

    public Habit(Date date, String name, ArrayList repeatDays) {
        this.date = date;
        this.name = name;
        this.repeatDays = repeatDays;
    }

    public Date getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList getDays() {
        return this.repeatDays;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return getName();
    }

    public void setDays(ArrayList repeatDays) {
        this.repeatDays = repeatDays;
    }

    public boolean if_occurstoday() {
        Calendar today = Calendar.getInstance();
        int today_int = today.get(Calendar.DAY_OF_WEEK);
        return repeatDays.contains(today);
    }
}

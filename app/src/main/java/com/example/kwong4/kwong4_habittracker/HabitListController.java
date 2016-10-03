package com.example.kwong4.kwong4_habittracker;

/**
 * Created by Wookiez on 10/2/2016.
 */
public class HabitListController {

    //Lazy Singleton
    private static HabitList habitlist = null;
    static public HabitList getHabitList() {
        if (habitlist == null) {
            habitlist = new HabitList();
        }
        return habitlist;
    }

    public void addHabit(Habit habit) {
        getHabitList().add(habit);
    }
}

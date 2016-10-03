package com.example.kwong4.kwong4_habittracker;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Wookiez on 10/2/2016.
 */
public class HabitListController {

    //Lazy Singleton
    private static HabitList habitlist = null;
    private static String habitfile_name;
    static public HabitList getHabitList(String habitfile) {
        habitfile_name = habitfile;
        if (habitlist == null) {
            try {
                habitlist = HabitListManager.getHabitListManager().loadHabitList(habitfile);
                habitlist.addListener(new Listener() {
                    @Override
                    public void update() {
                        saveHabitList();
                    }
                });
                return habitlist;
            } catch (RuntimeException e) {
                return new HabitList();
            }
        }
        return habitlist;
    }

    static public HabitList getHabitList() {
        if (habitlist == null) {
            return new HabitList();
        }
        return habitlist;
    }

    static public void saveHabitList() {
        HabitListManager.getHabitListManager().saveHabitList(habitfile_name, getHabitList());
    }

    public void addHabit(Habit habit) {
        getHabitList().add(habit);
    }

    public void deleteHabit(Habit habit) {
        getHabitList().delete(habit);
    }

    public void setHabits(ArrayList<Habit> habitlist) {
        getHabitList().setHabits(habitlist);
    }
}

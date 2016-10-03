package com.example.kwong4.kwong4_habittracker;

import java.util.ArrayList;

/**
 * Created by Wookiez on 10/3/2016.
 */
public class HabitListCompletionController {

    //Lazy Singleton
    private static HabitList habitlist = null;
    private static final String HABITFILE_COMPLETION = "habits_completed.sav";
    static public HabitList getHabitList() {
        if (habitlist == null) {
            try {
                habitlist = HabitListManager.getHabitListManager().loadHabitList();
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

    static public void saveHabitList() {
        HabitListManager.getHabitListManager().saveHabitList(getHabitList());
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

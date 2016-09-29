package com.example.kwong4.kwong4_habittracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Wookiez on 9/28/2016.
 */
public class HabitList {
    List<Habit> habitlist = new ArrayList<Habit>();

    public void add(Habit habit) {
        if (habitlist.contains(habit)) {
            throw new IllegalArgumentException("Duplicate Habit added.");
        }
        habitlist.add(habit);
    }

    public void delete(Habit habit) {
        habitlist.remove(habit);
    }

    public int getCount() {
        return habitlist.size();
    }

    public boolean hasHabit(Habit habit) {
        return habitlist.contains(habit);
    }

    public Habit getHabit(int i) {
        return habitlist.get(i);
    }

    public List<Habit> get_Habits() {
        return habitlist;
    }

    public void setHabits(ArrayList<Habit> habitlist) {
        this.habitlist = habitlist;
    }
    public List<Habit> get_sorted_Habits() {
        ArrayList<Habit> templist = new ArrayList<Habit>();
        Collections.sort(templist, new Comparator<Habit>() {
            public int compare(Habit habit1, Habit habit2) {
                return habit1.getDate().compareTo(habit2.getDate());
            }
        });
        return templist;
    }
}

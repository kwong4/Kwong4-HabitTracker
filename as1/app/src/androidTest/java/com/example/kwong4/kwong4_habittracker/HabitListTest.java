package com.example.kwong4.kwong4_habittracker;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Wookiez on 10/3/2016.
 */
public class HabitListTest extends ActivityInstrumentationTestCase2 {
    public HabitListTest() {
        super(HabitList.class);
    }
    public void testAddHabit() {
        HabitList list = new HabitList();

        Habit habit = new Habit(new Date(), "Push-Ups", new ArrayList(1));
        list.add(habit);
        assertTrue(list.hasHabit(habit));
    }

    public void testHasHabit() {
        HabitList list = new HabitList();

        Habit habit = new Habit(new Date(), "Push-Ups", new ArrayList(1));
        assertFalse(list.hasHabit(habit));
        list.add(habit);
        assertTrue(list.hasHabit(habit));
    }

    public void testGetHabit() {
        HabitList list = new HabitList();

        Habit a = new Habit(new Date(), "Push-Ups", new ArrayList(1));
        Habit b = new Habit(new Date(), "Push-Ups", new ArrayList(2));

        list.add(a);
        list.add(b);

        assertEquals(list.getHabit(0), a);
        assertEquals(list.getHabit(1), b);
    }

    public void testDeleteHabit() {
        HabitList list = new HabitList();

        Habit a = new Habit(new Date(), "Push-Ups", new ArrayList(1));

        list.add(a);
        assertTrue(list.hasHabit(a));

        list.delete(a);
        assertFalse(list.hasHabit(a));
    }

    public void testAddHabit2() {
        HabitList list = new HabitList();
        Habit a = new Habit(new Date(), "Push-Ups", new ArrayList(1));
        try {
            list.add(a);
            list.add(a);
            fail();
        }
        catch (IllegalArgumentException e) {
        }
    }

    public void testgetHabits() {
        HabitList list = new HabitList();
        HabitList list2 = new HabitList();

        Habit a = new Habit(new Date(), "Push-Ups", new ArrayList(1));
        Habit b = new Habit(new Date(), "Push-Ups", new ArrayList(2));
        a.setDate(new Date(1));
        list.add(a);
        list.add(b);
        list2.add(b);
        list2.add(a);
        List<Habit> sortedlist = list.get_sorted_Habits();
        List<Habit> sortedlist2 = list2.get_sorted_Habits();

        for (int i = 0; i < (sortedlist.size() - 1); i++) {
            assertTrue(sortedlist.get(i).getDate().compareTo(sortedlist.get(i + 1).getDate()) < 0);
        }
        for (int i = 0; i < (sortedlist2.size() - 1); i++) {
            assertTrue(sortedlist2.get(i).getDate().compareTo(sortedlist2.get(i + 1).getDate()) < 0);
        }
    }

    public void testhasTweet() {
        HabitList list = new HabitList();

        Habit a = new Habit(new Date(), "Push-Ups", new ArrayList(1));
        Habit b = new Habit(new Date(), "Push-Ups", new ArrayList(2));
        Habit c = new Habit(new Date(), "Push-Ups", new ArrayList(3));
        list.add(a);
        list.add(b);
        assertEquals(list.hasHabit(c), false);
        assertEquals(list.hasHabit(a), true);
    }

    public void testremoveTweet() {
        HabitList list = new HabitList();

        Habit a = new Habit(new Date(), "Push-Ups", new ArrayList(1));
        Habit b = new Habit(new Date(), "Push-Ups", new ArrayList(2));
        list.add(a);
        list.add(b);
        list.delete(a);
        assertEquals(list.getCount(), 1);
        assertEquals(list.hasHabit(a), false);
    }

    public void testgetCount() {
        HabitList list = new HabitList();

        Habit a = new Habit(new Date(), "Push-Ups", new ArrayList(1));
        Habit b = new Habit(new Date(), "Push-Ups", new ArrayList(2));
        list.add(a);
        list.add(b);
        assertEquals(list.getCount(), 2);
    }
}

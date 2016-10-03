package com.example.kwong4.kwong4_habittracker;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Wookiez on 10/3/2016.
 */
public class HabitTest extends ActivityInstrumentationTestCase2 {

    public HabitTest() {
        super(com.example.kwong4.kwong4_habittracker.Habit.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();
    }
}

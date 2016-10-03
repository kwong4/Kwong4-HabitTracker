package com.example.kwong4.kwong4_habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Modify_Habits extends AppCompatActivity {

    private HabitList habitlist = new HabitList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify__habits);
        HabitListManager.initManager(this.getApplicationContext());
        ListView habit_editlistview = (ListView) findViewById(R.id.Habit_List_Edit);
        ArrayAdapter<Habit> habit_editlistAdapter = new ArrayAdapter<Habit>(this, R.layout.habit_layout, habitlist.get_Habits());
        habit_editlistview.setAdapter(habit_editlistAdapter);

    }
}

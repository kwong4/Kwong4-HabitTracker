package com.example.kwong4.kwong4_habittracker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Wookiez on 9/28/2016.
 * Notes: - Need to create UML
 *        - DO Unit Tests
 *        - Make a README
 *        - Make Visual sticking for completion after one day.
 *        - Apply Repeat day tracking
 *        - APK file
 *        - Check that it works on lab machine (optional)
 *        - Right files in folders
 */
public class HabitActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HabitListManager.initManager(this.getApplicationContext());
        HabitListCompletionManager.initManager(this.getApplicationContext());
        ListView habit_listview = (ListView) findViewById(R.id.Habit_List);
        final ArrayList<Habit> current_habit_list = new ArrayList<Habit>(HabitListController.getHabitList().get_Habits());
        final ArrayAdapter<Habit> habit_listAdapter = new ArrayAdapter<Habit>(this, R.layout.habit_layout, current_habit_list);
        habit_listview.setAdapter(habit_listAdapter);
        //Added a change observer
        HabitListController.getHabitList().addListener(new Listener() {
            @Override
            public void update(){
                current_habit_list.clear();
                Collection<Habit> habit_collection = HabitListController.getHabitList().get_Habits();
                current_habit_list.addAll(habit_collection);
                habit_listAdapter.notifyDataSetChanged();
            }
        });

        habit_listview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ((TextView)view).setTextColor(Color.RED);
                Toast.makeText(HabitActivity.this, current_habit_list.get(position).toString() + " is marked complete.", Toast.LENGTH_SHORT).show();
                Habit marked_habit = current_habit_list.get(position);
                HabitListCompletionController.getHabitList().add(new Habit(new Date(), marked_habit.getName(), marked_habit.getDays()));
            }
        });
    }

    public void add_habit_button(View v) {
        Intent intent = new Intent(HabitActivity.this, Add_Habits.class);
        startActivity(intent);
    }

    public void history_button(View v) {
        Intent intent = new Intent(HabitActivity.this, Modify_History.class);
        startActivity(intent);
    }

    public void edit_button(View v) {
        Intent intent = new Intent(HabitActivity.this, Modify_Habits.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}

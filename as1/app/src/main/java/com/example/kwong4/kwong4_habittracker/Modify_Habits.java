package com.example.kwong4.kwong4_habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class Modify_Habits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify__habits);
        HabitListManager.initManager(this.getApplicationContext());
        ListView habit_editlistview = (ListView) findViewById(R.id.Habit_List_Edit);
        final ArrayList<Habit> current_habit_list = new ArrayList<Habit>(HabitListController.getHabitList().get_Habits());
        final ArrayAdapter<Habit> habit_listAdapter = new ArrayAdapter<Habit>(this, R.layout.habit_layout, current_habit_list);
        habit_editlistview.setAdapter(habit_listAdapter);

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

        habit_editlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(Modify_Habits.this, current_habit_list.get(position).toString() + " is deleted.", Toast.LENGTH_SHORT).show();
                Habit marked_habit = current_habit_list.get(position);
                HabitListController.getHabitList().delete(marked_habit);
            }
        });
    }
}

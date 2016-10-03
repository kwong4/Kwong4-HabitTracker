package com.example.kwong4.kwong4_habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class Modify_History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        HabitListCompletionManager.initManager(this.getApplicationContext());

        final ListView habitcompletion_listview = (ListView) findViewById(R.id.History_list_view);
        final ArrayList<Habit> current_completion_list = new ArrayList<Habit>(HabitListCompletionController.getHabitList().get_Habits());
        //final ArrayAdapter<Habit> completion_listAdapter = new ArrayAdapter<Habit>(this, R.layout.habit_layout, current_completion_list);
        final ArrayAdapter<Habit> completion_listAdapter = new CompletionViewAdapter(this, R.layout.history_layout, current_completion_list);
        habitcompletion_listview.setAdapter(completion_listAdapter);

        //Added a change observer
        HabitListCompletionController.getHabitList().addListener(new Listener() {
            @Override
            public void update(){
                current_completion_list.clear();
                Collection<Habit> habit_collection = HabitListCompletionController.getHabitList().get_Habits();
                current_completion_list.addAll(habit_collection);
                completion_listAdapter.notifyDataSetChanged();
            }
        });

        habitcompletion_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(Modify_History.this, current_completion_list.get(position).toString() + " is deleted.", Toast.LENGTH_SHORT).show();
                Habit marked_habit = current_completion_list.get(position);
                Switch toggle = (Switch) findViewById(R.id.count_switch);
                HabitListCompletionController.getHabitList().delete(marked_habit);
            }
        });
    }

    public void count_toggle(View v) {
        Switch toggle = (Switch) findViewById(R.id.count_switch);
        ListView habitcompletion_listview = (ListView) findViewById(R.id.History_list_view);
        if (!toggle.isChecked()) {
            final ArrayList<Habit> current_completion_list = new ArrayList<Habit>(HabitListCompletionController.getHabitList().get_Habits());
            final ArrayAdapter<Habit> completion_listAdapter = new CompletionViewAdapter(this, R.layout.history_layout, current_completion_list);
            habitcompletion_listview.setAdapter(completion_listAdapter);
        } else {
            Map map = new HashMap();
            final ArrayList<Habit> current_completion_list = new ArrayList<Habit>(HabitListCompletionController.getHabitList().get_Habits());
            for (int i =0; i < current_completion_list.size(); i++) {
                if (map.containsKey(current_completion_list.get(i).getName())) {
                    Integer val = (Integer) map.get(current_completion_list.get(i).getName());
                    map.put(current_completion_list.get(i).getName(), val + 1);
                }
                else {
                    map.put(current_completion_list.get(i).getName(), 1);
                }
            }
            final CountViewAdapter count_listAdapter = new CountViewAdapter(map);
            habitcompletion_listview.setAdapter(count_listAdapter);
        }
    }
}

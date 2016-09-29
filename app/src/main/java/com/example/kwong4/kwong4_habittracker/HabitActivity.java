package com.example.kwong4.kwong4_habittracker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Wookiez on 9/28/2016.
 */
public class HabitActivity extends Activity {

    private static final String HABITFILE = "habits.sav";
    private EditText current_text;
    private ListView current_view;

    private HabitList habitlist = new HabitList();

    private ArrayAdapter<Habit> adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        load_habits_from_file();
        adapter = new ArrayAdapter<Habit>(this, R.id.Habit_List);

    }

    private void load_habits_from_file() {
        try {
            FileInputStream fis = openFileInput(HABITFILE);
            BufferedReader in  = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            //Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();
            habitlist.setHabits((ArrayList<Habit>) gson.fromJson(in, listType));
        } catch (FileNotFoundException e) {
            habitlist.setHabits(new ArrayList<Habit>());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void save_habits_to_file() {
        try {
            FileOutputStream fos = openFileOutput(HABITFILE, 0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(habitlist.get_Habits(), out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

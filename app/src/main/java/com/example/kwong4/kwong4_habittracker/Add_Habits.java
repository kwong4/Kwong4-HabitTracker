package com.example.kwong4.kwong4_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Add_Habits extends AppCompatActivity {

    private static final String HABITFILE = "habits.sav";

    private HabitList habitlist = new HabitList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habit_tracker_add);
        HabitListManager.initManager(this.getApplicationContext());
        EditText date = (EditText) findViewById(R.id.Date_input);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date current_date = new Date();
        date.setText(dateFormat.format(current_date));
    }

    @Override
    protected void onStart() {
        super.onStart();
        //adapter = new ArrayAdapter<Habit>(this, R.layout.habit_layout);
    }

    public void add_habit(View v) {
        try {
            EditText date = (EditText) findViewById(R.id.Date_input);
            EditText name = (EditText) findViewById(R.id.Name_input);
            String habit_name = name.getText().toString();
            if (!habit_name.matches("")) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date current_date = new Date();
                date.setText(dateFormat.format(current_date));
                String date_text = date.getText().toString();
                Date habit_date = dateFormat.parse(date_text);
                CheckBox monday = (CheckBox) findViewById(R.id.checkBox_Mon);
                CheckBox tuesday = (CheckBox) findViewById(R.id.checkBox_Tues);
                CheckBox wednesday = (CheckBox) findViewById(R.id.checkBox_Wed);
                CheckBox thursday = (CheckBox) findViewById(R.id.checkBox_Thurs);
                CheckBox friday = (CheckBox) findViewById(R.id.checkBox_Fri);
                CheckBox saturday = (CheckBox) findViewById(R.id.checkBox_Sat);
                CheckBox sunday = (CheckBox) findViewById(R.id.checkBox_Sun);
                if (monday.isChecked() || tuesday.isChecked() || wednesday.isChecked() || thursday.isChecked() || friday.isChecked() || saturday.isChecked() || sunday.isChecked()) {
                    ArrayList repeatDays = new ArrayList();
                    if (monday.isChecked()) {
                        repeatDays.add(0);
                    }
                    if (tuesday.isChecked()) {
                        repeatDays.add(1);
                    }
                    if (wednesday.isChecked()) {
                        repeatDays.add(2);
                    }
                    if (thursday.isChecked()) {
                        repeatDays.add(3);
                    }
                    if (friday.isChecked()) {
                        repeatDays.add(4);
                    }
                    if (saturday.isChecked()) {
                        repeatDays.add(5);
                    }
                    if (sunday.isChecked()) {
                        repeatDays.add(6);
                    }
                    Habit custom_habit = new Habit(habit_date, habit_name, repeatDays);
                    Toast.makeText(Add_Habits.this, "Habit Added!", Toast.LENGTH_SHORT).show();
                    HabitListController.getHabitList().add(custom_habit);
                }
                else {
                    Toast.makeText(Add_Habits.this, "Please select repeating Days", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                name.setError("Please define a Habit Name");
            }
        } catch (ParseException ex) {
            EditText date = (EditText) findViewById(R.id.Date_input);
            date.setError("Invalid format. Please use format yyyy/MM/dd");
        }
    }
}

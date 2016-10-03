package com.example.kwong4.kwong4_habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Modify_History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        HabitListManager.initManager(this.getApplicationContext());
    }
}

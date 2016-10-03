package com.example.kwong4.kwong4_habittracker;

import android.content.Context;

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
 * Created by Wookiez on 10/2/2016.
 */
public class HabitListManager {
    private Context context;
    static private HabitListManager habitlistmanager = null;
    private static final String HABITFILE = "habits.sav";

    public HabitListManager(Context context) {
        this.context = context;
    }

    public static void initManager(Context context) {
        if (habitlistmanager == null) {
            if (context == null) {
                throw new RuntimeException("Missing context for HabitListManager");
            }
            habitlistmanager = new HabitListManager(context);
        }
    }

    public static HabitListManager getHabitListManager() {
        if (habitlistmanager == null) {
            throw new RuntimeException("Did not initialize manager");
        }
        return habitlistmanager;
    }

    public HabitList loadHabitList() {
        try {
            FileInputStream fis = context.openFileInput(HABITFILE);
            BufferedReader in  = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            //Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();

            HabitList loaded_habitlist = new HabitList();
            loaded_habitlist.setHabits((ArrayList<Habit>) gson.fromJson(in, listType));
            return loaded_habitlist;
        } catch (FileNotFoundException e) {
            return new HabitList();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void saveHabitList(HabitList hl) {
        try {
            FileOutputStream fos = context.openFileOutput(HABITFILE, 0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(hl.get_Habits(), out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

package com.example.t00584336.project_v1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.t00584336.project_v1.MainActivity.CALORIE_COUNT;

public class WeightActivity extends Activity {

    public static final String WORKOUT_NAME = "WORKOUT KEY";

    SharedPreferences sharedPreferences;
    int caloriecount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        sharedPreferences = this.getSharedPreferences(MainActivity.MY_SHARED_PREF_FILE, Context.MODE_PRIVATE);

        ListView listView = (ListView) findViewById(R.id.weightlist);

        final ArrayList<Exercises> weightex = new ArrayList<>();
        Exercises e1 = new Exercises("Pushups", 156);
        Exercises e2 = new Exercises("Situps", 156);
        Exercises e3 = new Exercises("Jumping Jacks", 156);
        Exercises e4 = new Exercises("Farmer's Carry, 1 to 15 lbs", 89);
        Exercises e5 = new Exercises("Farmer's Carry, 16 to 24 lbs", 111);
        Exercises e6 = new Exercises("Farmer's Carry, 25 to 49 lbs", 156);
        Exercises e7 = new Exercises("Farmer's Carry, 50 to 74 lbs", 200);
        Exercises e8 = new Exercises("Farmer's Carry, 74 lbs and heavier", 245);

        weightex.add(e1);
        weightex.add(e2);
        weightex.add(e3);
        weightex.add(e4);
        weightex.add(e5);
        weightex.add(e6);
        weightex.add(e7);
        weightex.add(e8);

        ArrayAdapter<Exercises> adapter = new ArrayAdapter<Exercises>(this, android.R.layout.simple_list_item_1, weightex);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Exercises e = weightex.get(position);
                String name = e.getName();
                int calories = e.getCalories();

                Toast.makeText(getApplicationContext(), "You added the " + name + " exercise to the workout", Toast.LENGTH_LONG).show();

                Intent intent = getIntent();
                caloriecount = intent.getIntExtra(MainActivity.CALORIE_COUNT, caloriecount);

                caloriecount = caloriecount + calories;
                //Test to check if current calorie count works
                //Toast.makeText(getApplicationContext(), "Calorie Count = " + caloriecount,Toast.LENGTH_LONG).show();
                save();
            }
        });
    }
    private void save() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(MainActivity.CALORIE_COUNT, caloriecount);
        editor.apply();
    }
}




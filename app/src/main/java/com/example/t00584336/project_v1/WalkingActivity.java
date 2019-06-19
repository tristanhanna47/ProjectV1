package com.example.t00584336.project_v1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class WalkingActivity extends Activity {

    public static final String WORKOUT_KEY = "workout_key";

    SharedPreferences sharedPreferences;
    int caloriecount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);

        sharedPreferences = this.getSharedPreferences(MainActivity.MY_SHARED_PREF_FILE, Context.MODE_PRIVATE);

        ListView listView = (ListView) findViewById(R.id.walkinglist);

        final ArrayList<Exercises> walkingex = new ArrayList<>();
        Exercises e1 = new Exercises("Backpacking", 134);
        Exercises e2 = new Exercises("Climbing Hills with 0 - 9 lbs", 134);
        Exercises e3 = new Exercises("Climbing Hills with 10 to 20 lbs", 145);
        Exercises e4 = new Exercises("Climbing Hills with 21 to 42 lbs", 156);
        Exercises e5 = new Exercises("Climbing Hills with 42 lbs and heavier", 178);
        Exercises e6 = new Exercises("Walking less than 2 mph", 22);
        Exercises e7 = new Exercises("Walking at 2.5 mph", 45);
        Exercises e8 = new Exercises("Walking at 2.5 mph, Downhill",20);
        Exercises e9 = new Exercises("Walking at 3 mph", 51);
        Exercises e10 = new Exercises("Walking at 3.5 mph",62);
        Exercises e11 = new Exercises("Walking at 3.5 mph, Uphill", 111);
        Exercises e12 = new Exercises("Walking at 4 mph",89);
        Exercises e13 = new Exercises("Walking at 4.5 mph", 118);
        Exercises e14 = new Exercises("Walking at 5 mph",156);

        walkingex.add(e1);
        walkingex.add(e2);
        walkingex.add(e3);
        walkingex.add(e4);
        walkingex.add(e5);
        walkingex.add(e6);
        walkingex.add(e7);
        walkingex.add(e8);
        walkingex.add(e9);
        walkingex.add(e10);
        walkingex.add(e11);
        walkingex.add(e12);
        walkingex.add(e13);
        walkingex.add(e14);

        ArrayAdapter<Exercises> adapter = new ArrayAdapter<Exercises>(this, android.R.layout.simple_list_item_1, walkingex);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Exercises e = walkingex.get(position);
                String name = e.getName();
                int calories = e.getCalories();

                Toast.makeText(getApplicationContext(), "You added the " + name + " exercise to the workout", Toast.LENGTH_LONG).show();

                Intent intent = getIntent();
                caloriecount = intent.getIntExtra(MainActivity.CALORIE_COUNT, caloriecount);

                caloriecount = caloriecount + calories;
                //Test to check if current calorie count works
                Toast.makeText(getApplicationContext(), "Calorie Count = " + caloriecount,Toast.LENGTH_LONG).show();
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

package com.example.t00584336.project_v1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class WalkingActivity extends Activity {

    SharedPreferences sharedPreferences;
    int caloriecount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);

        sharedPreferences = this.getSharedPreferences(MainActivity.MY_SHARED_PREF_FILE, Context.MODE_PRIVATE);

        ListView listView = (ListView) findViewById(R.id.walkinglist);

        final ArrayList<Exercises> walkingex = new ArrayList<>();
        Exercises e1 = new Exercises("100m Walk", 450);
        Exercises e2 = new Exercises("150m Walk", 4500);

        walkingex.add(e1);
        walkingex.add(e2);

        ArrayAdapter<Exercises> adapter = new ArrayAdapter<Exercises>(this, android.R.layout.simple_list_item_1, walkingex);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Exercises e = walkingex.get(position);
                String name = e.getName();
                int calories = e.getCalories();

                Toast.makeText(getApplicationContext(), "You added the " + name + " exercise to the workout", Toast.LENGTH_LONG).show();

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
        editor.commit();
    }
}

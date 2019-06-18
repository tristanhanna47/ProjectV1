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

public class SwimmingActivity extends Activity {

    SharedPreferences sharedPreferences;
    int caloriecount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swimming);

        sharedPreferences = this.getSharedPreferences(MainActivity.MY_SHARED_PREF_FILE, Context.MODE_PRIVATE);

        ListView listView = (ListView) findViewById(R.id.swimminglist);

        final ArrayList<Exercises> swimmingex = new ArrayList<>();
        Exercises e6 = new Exercises("Backstroke", 134);
        Exercises e5 = new Exercises("Breaststroke", 200);
        Exercises e4 = new Exercises("Butterfly Stroke", 223);
        Exercises e10 = new Exercises("Canoeing at 2 - 3.9 mph",45);
        Exercises e11 = new Exercises("Canoeing at 4 - 5.9 mph", 134);
        Exercises e12 = new Exercises("Canoeing at greater than 6 mph", 245);
        Exercises e8 = new Exercises("Freestyle, Vigorous Effort", 200);
        Exercises e7 = new Exercises("Freestyle, Moderate Effort", 134);
        Exercises e9 = new Exercises("Scuba Diving", 134);
        Exercises e3 = new Exercises("Sidestroke", 156);
        Exercises e1 = new Exercises("Treading Water, Moderate Effort", 67);
        Exercises e2 = new Exercises("Treading water, Vigorous Effort", 200);

        swimmingex.add(e1);
        swimmingex.add(e2);
        swimmingex.add(e3);
        swimmingex.add(e4);
        swimmingex.add(e5);
        swimmingex.add(e6);
        swimmingex.add(e7);
        swimmingex.add(e8);
        swimmingex.add(e9);
        swimmingex.add(e10);
        swimmingex.add(e11);
        swimmingex.add(e12);

        ArrayAdapter<Exercises> adapter = new ArrayAdapter<Exercises>(this,android.R.layout.simple_list_item_1, swimmingex );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Exercises e = swimmingex.get(position);
                String name = e.getName();
                int calories = e.getCalories();

                Toast.makeText(getApplicationContext(), "You added the " + name + " exercise to the workout",Toast.LENGTH_LONG).show();

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
        editor.commit();
    }
}

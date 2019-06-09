package com.example.t00584336.project_v1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.t00584336.project_v1.CaloriecountGlobal.caloriecount;

public class RunningActivity extends Activity implements Serializable {

//    public static final String NUMBER_KEY = "com.example.t00584336.NUMBER_KEY";
//    public static final String POTATO = "potato";
//    private int caloriecount;
//    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);

//        sharedPreferences = getSharedPreferences(POTATO, MODE_PRIVATE);
//        caloriecount = sharedPreferences.getInt(NUMBER_KEY,0);

        ListView listView = (ListView) findViewById(R.id.runninglist);

        final ArrayList<Exercises> runningex = new ArrayList<>();
        Exercises e1 = new Exercises("150m Sprint", 150);
        Exercises e2 = new Exercises("100m Sprint", 1500);

        runningex.add(e1);
        runningex.add(e2);

        ArrayAdapter<Exercises> adapter = new ArrayAdapter<Exercises>(this,android.R.layout.simple_list_item_1, runningex );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Exercises e = runningex.get(position);
                String name = e.getName();
                int calories = e.getCalories();

                Toast.makeText(getApplicationContext(), "You added the " + name + " exercise to the workout",Toast.LENGTH_LONG).show();

                caloriecount = caloriecount + calories;
                //Test to check if current calorie count works
                //Toast.makeText(getApplicationContext(), "Calorie Count = " + caloriecount,Toast.LENGTH_LONG).show();
            }
        });
    }
}


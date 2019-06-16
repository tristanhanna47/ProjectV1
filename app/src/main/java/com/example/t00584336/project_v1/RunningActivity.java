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

public class RunningActivity extends Activity {

    SharedPreferences sharedPreferences;
    SharedPreferences sp;
    int caloriecount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);

        sharedPreferences = this.getSharedPreferences(MainActivity.MY_SHARED_PREF_FILE, Context.MODE_PRIVATE);

        ListView listView = (ListView) findViewById(R.id.runninglist);

        final ArrayList<Exercises> runningex = new ArrayList<>();
        Exercises e1 = new Exercises("150m Sprint", 550);
        Exercises e2 = new Exercises("100m Sprint", 5500);
        Exercises e3 = new Exercises("General Jogging", 134);
        Exercises e4 = new Exercises("Jogging in Place", 156);
        Exercises e5 = new Exercises("Running at 5 mph", 156);
        Exercises e6 = new Exercises("Running at 5.2 mph", 178);
        Exercises e7 = new Exercises("Running at 6 mph", 200);
        Exercises e8 = new Exercises("Running at 6.7 mph",223);
        Exercises e9 = new Exercises("Running at 7 mph", 234);
        Exercises e10= new Exercises("Running at 7.5 mph",256);
        Exercises e11= new Exercises("Running at 8 mph",278);
        Exercises e12= new Exercises("Running at 8.6 mph", 289);
        Exercises e13= new Exercises("Running at 9 mph", 312);
        Exercises e14= new Exercises("Running at 10 mph", 334);
        Exercises e15= new Exercises("Running at 10.9 mph",378);
        Exercises e16= new Exercises("Treadmill, Light Effort", 149);
        Exercises e17= new Exercises("Treadmill, Hard Effort", 200);
        Exercises e18= new Exercises("Treadmill, Vigorous Effort", 312);
        Exercises e19= new Exercises("Water Jogging", 156);
//        Exercises e18= new Exercises();
//        Exercises e19= new Exercises();
//        Exercises e20= new Exercises();
//        Exercises e21= new Exercises();
//        Exercises e22= new Exercises();
//        Exercises e23= new Exercises();
//        Exercises e24= new Exercises();

        runningex.add(e1);
        runningex.add(e2);
        runningex.add(e3);
        runningex.add(e4);
        runningex.add(e5);
        runningex.add(e6);
        runningex.add(e7);
        runningex.add(e8);
        runningex.add(e9);
        runningex.add(e10);
        runningex.add(e11);
        runningex.add(e12);
        runningex.add(e13);
        runningex.add(e14);
        runningex.add(e15);
        runningex.add(e16);
        runningex.add(e17);
        runningex.add(e18);
        runningex.add(e19);

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


package com.example.t00584336.project_v1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String MY_SHARED_PREF_FILE = "my_shared_pref_file";
    public static final String CALORIE_COUNT = "caloriecount_key";

    int caloriecount;
    TextView caloriecounter;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caloriecounter = findViewById(R.id.caloriecounter);

        sharedPreferences = this.getSharedPreferences(MY_SHARED_PREF_FILE, Context.MODE_PRIVATE);
        caloriecount = sharedPreferences.getInt(CALORIE_COUNT,0);
       // Intent intent = getIntent();
       // caloriecount = intent.getIntExtra(CALORIE_COUNT,0);

        //caloriecount = sharedPreferences.getInt(CALORIE_COUNT, 0);
        caloriecounter.setText("Your current workout burns "+ String.valueOf(caloriecount) + " calories");
    }

    public void gotoweight (View view)
    {
        Intent intent = new Intent(this, WeightActivity.class);
        startActivity (intent);
    }

    public void gotorunning (View view)
    {
        Intent intent = new Intent(this, RunningActivity.class);
        startActivity (intent);
    }

    public void gotoswimming (View view)
    {
        Intent intent = new Intent(this, SwimmingActivity.class);
        startActivity (intent);
    }

    public void gotowalking (View view)
    {
        Intent intent = new Intent(this, WalkingActivity.class);
        startActivity (intent);
    }

    public void gotoworkout (View view)
    {
        Intent intent = new Intent(this, CurrentWorkoutActivity.class);
        startActivity (intent);
    }



}

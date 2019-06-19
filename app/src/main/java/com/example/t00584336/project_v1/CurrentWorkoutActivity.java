package com.example.t00584336.project_v1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class CurrentWorkoutActivity extends Activity {

    public static final String WORKOUT_KEY = "workout_key";

    public static final String MY_WORKOUT_PREFERENCE = "my_workout_preference";
    SharedPreferences sp;

    String exercise;
    TextView workoutview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_workout);

        workoutview = findViewById(R.id.workoutview);

        Intent intent = getIntent();
        exercise = intent.getStringExtra(WeightActivity.WORKOUT_NAME);
        sp = getSharedPreferences(MY_WORKOUT_PREFERENCE, MODE_PRIVATE);

        sp = this.getSharedPreferences(MY_WORKOUT_PREFERENCE, Context.MODE_PRIVATE);
        exercise = sp.getString(WORKOUT_KEY,"Nothing yet");
        workoutview.setText(exercise);
    }
}

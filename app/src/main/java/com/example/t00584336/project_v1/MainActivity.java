package com.example.t00584336.project_v1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public static final String Exercise_Key = "com.example.t00584336.Exercise_Key";

//    TextView numbertext;
//    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        numbertext = findViewById(R.id.numbertext);
//        Intent intent = getIntent();
//        int caloriecount = intent.getIntExtra(RunningActivity.NUMBER_KEY, 0);
//        numbertext.setText(caloriecount);
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

//
//    public void gotolegs (View view)
//    {
//        Intent intent = new Intent(this, LegActivity.class);
//        //intent.putExtra(Ccount, calories);
//        startActivity (intent);
//    }


}

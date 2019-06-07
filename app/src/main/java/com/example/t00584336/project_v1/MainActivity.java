package com.example.t00584336.project_v1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    public static final String Exercise_Key = "com.example.t00584336.Exercise_Key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotochest (View view)
    {
        Intent intent = new Intent(this, ChestActivity.class);
        //intent.putExtra(Ccount, calories);
        startActivity (intent);
    }

    public void gotoback (View view)
    {
        Intent intent = new Intent(this, BackActivity.class);
        //intent.putExtra(Ccount, calories);
        startActivity (intent);
    }

    public void gotobicep (View view)
    {
        Intent intent = new Intent(this, BicepActivity.class);
        //intent.putExtra(Ccount, calories);
        startActivity (intent);
    }

    public void gototricep (View view)
    {
        Intent intent = new Intent(this, TricepActivity.class);
        //intent.putExtra(Ccount, calories);
        startActivity (intent);
    }

    public void gotolegs (View view)
    {
        Intent intent = new Intent(this, LegActivity.class);
        //intent.putExtra(Ccount, calories);
        startActivity (intent);
    }


}

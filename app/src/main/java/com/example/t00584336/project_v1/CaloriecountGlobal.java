package com.example.t00584336.project_v1;

import android.app.Application;

public class CaloriecountGlobal extends Application{

    public static int caloriecount = 0;

    private static CaloriecountGlobal caloriecounter;

    public static CaloriecountGlobal getInstance(){
        return caloriecounter;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        caloriecounter = this;
    }
}

package com.example.t00584336.project_v1;

class Exercises {
    private String name;
    private int calories;

    public Exercises()
    {
        super();
    }

    public Exercises(String name, int calories)
    {
        super();
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return this.name + "(" + this.calories + " calories)";
    }
}

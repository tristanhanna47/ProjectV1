package com.example.t00584336.project_v1;

class ChestExercises {
    private String name;
    private int calories;

    public ChestExercises()
    {
        super();
    }

    public ChestExercises (String name, int calories)
    {
        super();
        this.name = name;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return this.name + "( " + this.calories + " calories)";
    }
}

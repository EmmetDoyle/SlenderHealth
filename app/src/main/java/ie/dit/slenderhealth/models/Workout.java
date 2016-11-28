package ie.dit.slenderhealth.models;

import java.util.ArrayList;

/**
 * Created by c11428058 on 24/11/2016.
 */
public class Workout {

    private String name;
    private ArrayList<Exercise> exercises = new ArrayList<>();
    private long id;

    public Workout(){

    }

    public Workout(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}

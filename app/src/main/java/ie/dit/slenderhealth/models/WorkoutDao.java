package ie.dit.slenderhealth.models;

import android.content.Context;

import ie.dit.slenderhealth.DbManager;

/**
 * Created by c11428058 on 28/11/2016.
 */

public class WorkoutDao {

    DbManager manager;

    public WorkoutDao(Context context){
        manager = new DbManager(context);
    }

    public long insertWorkout(Workout workout){
        manager.open();
        int id = (int)manager.insertWorkout(workout.toString());

        for(Exercise exercise : workout.getExercises()){
            manager.insertExercise(
                    exercise.getWeight(),
                    exercise.getReps(),
                    exercise.getSets(),
                    exercise.getMachine().getId(),
                    id);
        }
        manager.close();
        return id;
    }
}

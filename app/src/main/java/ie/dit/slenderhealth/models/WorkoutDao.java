package ie.dit.slenderhealth.models;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

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

    public ArrayList<Workout> getAllWorkouts(){
        manager.open();

        Cursor cursor = manager.getAllWorkouts();
        //   loop over the returned cursor
        //   At each loop create a Machine object from the cursor data
        ArrayList<Workout> workouts = new ArrayList<>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String name = cursor.getString(cursor.getColumnIndex(DbManager.KEY_W_NAME));
            int id = cursor.getInt(0);

            workouts.add(new Workout(name, id));
            cursor.moveToNext();
        }

        manager.close();

        //   Add Machine object to array/list
        //   return array/list
        return workouts;
    }
}

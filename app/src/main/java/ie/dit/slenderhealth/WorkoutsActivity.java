package ie.dit.slenderhealth;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ie.dit.slenderhealth.models.Workout;
import ie.dit.slenderhealth.models.WorkoutDao;

public class WorkoutsActivity extends ListActivity {
    ArrayList<Workout> workouts = new ArrayList<>();

    private WorkoutDao workoutDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        workoutDao = new WorkoutDao(this);
        workouts = workoutDao.getAllWorkouts();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);

        setListAdapter(new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, workouts));

        findViewById(R.id.addWorkout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkoutsActivity.this, AddWorkoutActivity.class);
                startActivity(intent);
            }
        });
    }


}

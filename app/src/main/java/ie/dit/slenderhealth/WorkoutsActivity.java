package ie.dit.slenderhealth;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class WorkoutsActivity extends ListActivity {
    ArrayList<Workout> workouts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        workouts.add(new Workout("Abs Attack!!"));
        workouts.add(new Workout("leg!!"));
        workouts.add(new Workout("arms Attack!!"));
        workouts.add(new Workout("Heart Attack!!"));


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

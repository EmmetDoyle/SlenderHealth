package ie.dit.slenderhealth;

/*
* Created by Emmet Doyle
*AddWorkoutActivity
* Activity for adding workouts to db
* Adds exercises to Exercise array until
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import ie.dit.slenderhealth.models.Exercise;
import ie.dit.slenderhealth.models.Machine;
import ie.dit.slenderhealth.models.MachineDao;
import ie.dit.slenderhealth.models.Workout;
import ie.dit.slenderhealth.models.WorkoutDao;

public class AddWorkoutActivity extends Activity implements View.OnClickListener{

    private WorkoutDao workoutDao;
    //private exerciseDao;
    private MachineDao machineDao;
    private Workout workout;
    private Exercise currentExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        machineDao = new MachineDao(this);
        workoutDao = new WorkoutDao(this);
        workout = new Workout();
        currentExercise = new Exercise();

        final Machine[] machines = machineDao.getAllMachines();

        final Spinner machine = (Spinner)findViewById(R.id.machine);
        ArrayAdapter<Machine> machineAdapter = new ArrayAdapter<Machine>(this, android.R.layout.simple_spinner_item, machines);
        machine.setAdapter(machineAdapter);

        final Spinner weights = (Spinner)findViewById(R.id.weight);

        machine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<Integer> weightsAdapter = new ArrayAdapter<Integer>(AddWorkoutActivity.this, android.R.layout.simple_spinner_item, machines[position].getWeights());
                weights.setAdapter(weightsAdapter);
                currentExercise.setMachine(machines[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ArrayAdapter<Integer> weightsAdapter = new ArrayAdapter<Integer>(AddWorkoutActivity.this, android.R.layout.simple_spinner_item, machines[0].getWeights());
                weights.setAdapter(weightsAdapter);
            }
        });

        weights.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentExercise.setWeight((int)weights.getAdapter().getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SeekBar repsSeekBar = (SeekBar)findViewById(R.id.repsSeekBar);
        repsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView textView = (TextView)findViewById(R.id.reps);
                textView.setText("" + (progress + 1));
                currentExercise.setReps(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar setsSeekBar = (SeekBar)findViewById(R.id.setsSeekBar);
        setsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView textView = (TextView)findViewById(R.id.sets);
                textView.setText("" + (progress + 1));
                currentExercise.setSets(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        findViewById(R.id.addExercise).setOnClickListener(this);
        findViewById(R.id.submit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addExercise:
                addExerciseToWorkout();
                break;

            case R.id.submit:
                EditText workoutName = (EditText) findViewById(R.id.workoutName);
                workout.setName(workoutName.getText().toString());
                workoutDao.insertWorkout(workout);
                break;
        }
    }

    private void addExerciseToWorkout(){
        workout.addExercise(currentExercise);
        currentExercise = new Exercise();

        // Possibly reset inputs
    }
}

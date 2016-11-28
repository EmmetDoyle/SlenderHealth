package ie.dit.slenderhealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import ie.dit.slenderhealth.models.Exercise;
import ie.dit.slenderhealth.models.Machine;
import ie.dit.slenderhealth.models.MachineDao;
import ie.dit.slenderhealth.models.Workout;

public class AddWorkoutActivity extends Activity implements View.OnClickListener{

    private workoutDao;
    //private exerciseDao;
    private MachineDao machineDao;
    private Workout workout;
    private Exercise currentExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        machineDao = new MachineDao(this);
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

        // TODO: 28/11/2016 when Add clicked, get values of all views on screen and add them to exercise array
        findViewById(R.id.addExercise).setOnClickListener(this);
        // TODO: 28/11/2016 when Finish clicked, add all exercises to workout
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addExercise:
                addExerciseToWorkout();
        }
    }

    private void addExerciseToWorkout(){
        workout.addExercise(currentExercise);
        currentExercise = new Exercise();

        // Possibly reset inputs
    }
}

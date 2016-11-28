package ie.dit.slenderhealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ie.dit.slenderhealth.models.Machine;
import ie.dit.slenderhealth.models.MachineDao;

public class AddWorkoutActivity extends Activity {

    //private workoutDao;
    //private exerciseDao;
    private MachineDao machineDao;
    Machine[] machines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        // Machine[] machines = machineDao.getAllMachines();

        Spinner machine = (Spinner)findViewById(R.id.machine);
        ArrayAdapter<Machine> machineAdapter = new ArrayAdapter<Machine>(this, android.R.layout.simple_spinner_item, machines);
        machine.setAdapter(machineAdapter);

        final Spinner weights = (Spinner)findViewById(R.id.weight);


        machine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<Integer> weightsAdapter = new ArrayAdapter<Integer>(AddWorkoutActivity.this, android.R.layout.simple_spinner_item, machines[position].getWeights());
                weights.setAdapter(weightsAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ArrayAdapter<Integer> weightsAdapter = new ArrayAdapter<Integer>(AddWorkoutActivity.this, android.R.layout.simple_spinner_item, machines[0].getWeights());
                weights.setAdapter(weightsAdapter);
            }
        });

        // TODO: 28/11/2016 when Add clicked, get values of all views on screen and add them to exercise array
        // TODO: 28/11/2016 when Finish clicked, add all exercises to workout
    }


}

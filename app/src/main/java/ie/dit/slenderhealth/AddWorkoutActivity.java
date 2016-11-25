package ie.dit.slenderhealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ie.dit.slenderhealth.models.Machine;

public class AddWorkoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        final Machine[] machines = {new Machine("Leg Curler", 10, 150, 10), new Machine("Shoulder Press", 20, 200, 20)};

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
    }


}

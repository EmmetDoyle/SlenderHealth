package ie.dit.slenderhealth;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ie.dit.slenderhealth.models.Assessment;

public class ProgressActivity extends ListActivity {
    ArrayList<Assessment> assessments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        assessments.add(new Assessment("25/01/2016", 181, 68, 17, 45, 40, 42, 43, 22, 18, 17));
        assessments.add(new Assessment("25/03/2016", 181, 67, 16, 45, 40, 42, 43, 22, 18, 17));
        assessments.add(new Assessment("25/05/2016", 181, 66, 16, 45, 40, 42, 43, 22, 18, 17));
        assessments.add(new Assessment("25/07/2016", 181, 65, 15, 45, 40, 42, 43, 22, 18, 17));
        assessments.add(new Assessment("25/09/2016", 181, 64, 14, 45, 40, 42, 43, 22, 18, 17));
        assessments.add(new Assessment("25/11/2016", 181, 63, 13, 45, 40, 42, 43, 22, 18, 17));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        setListAdapter(new ArrayAdapter<Assessment>(this, android.R.layout.simple_list_item_1, assessments));

        findViewById(R.id.addAssessment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProgressActivity.this, AddAssessmentActivity.class);
                startActivity(intent);
            }
        });
    }


}

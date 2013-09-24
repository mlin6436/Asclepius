package uk.nhs.kch.asclepius;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Disability extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disability);

        Spinner disability_eye_spinner = (Spinner) findViewById(R.id.disability_eye_spinner);
        ArrayAdapter<CharSequence> disability_eye_adapter = ArrayAdapter.createFromResource(this,
                R.array.disbility_eye, android.R.layout.simple_spinner_item);
        disability_eye_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        disability_eye_spinner.setAdapter(disability_eye_adapter);

        Spinner disability_verbal_spinner = (Spinner) findViewById(R.id.disability_verbal_spinner);
        ArrayAdapter<CharSequence> disability_verbal_adapter = ArrayAdapter.createFromResource(this,
                R.array.disbility_verbal, android.R.layout.simple_spinner_item);
        disability_verbal_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        disability_verbal_spinner.setAdapter(disability_verbal_adapter);

        Spinner disability_motor_spinner = (Spinner) findViewById(R.id.disability_motor_spinner);
        ArrayAdapter<CharSequence> disability_motor_adapter = ArrayAdapter.createFromResource(this,
                R.array.disbility_motor, android.R.layout.simple_spinner_item);
        disability_motor_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        disability_motor_spinner.setAdapter(disability_motor_adapter);

        Spinner disability_leftpupilsize_spinner = (Spinner) findViewById(R.id.disability_leftpupilsize_spinner);
        ArrayAdapter<CharSequence> disability_leftpupilsize_adapter = ArrayAdapter.createFromResource(this,
                R.array.disability_leftpupilsize, android.R.layout.simple_spinner_item);
        disability_leftpupilsize_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        disability_leftpupilsize_spinner.setAdapter(disability_leftpupilsize_adapter);

        Spinner disability_rightpupilsize_spinner = (Spinner) findViewById(R.id.disability_rightpupilsize_spinner);
        ArrayAdapter<CharSequence> disability_rightpupilsize_adapter = ArrayAdapter.createFromResource(this,
                R.array.disability_rightpupilsize, android.R.layout.simple_spinner_item);
        disability_rightpupilsize_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        disability_rightpupilsize_spinner.setAdapter(disability_rightpupilsize_adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.disability, menu);
        return true;
    }

    public void onButtonClick_Next(View view){
        Intent intent = new Intent(this, Exposure.class);
        startActivity(intent);
    }
}

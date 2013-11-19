package uk.nhs.kch.asclepius;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Disability extends Activity {
    private int eye_score = 0;
    private int verbal_score = 0;
    private int motor_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disability);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        Spinner disability_eye_spinner = (Spinner) findViewById(R.id.disability_eye_spinner);
        ArrayAdapter<CharSequence> disability_eye_adapter = ArrayAdapter.createFromResource(this,
                R.array.disbility_eye, android.R.layout.simple_spinner_item);
        disability_eye_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        disability_eye_spinner.setAdapter(disability_eye_adapter);
        disability_eye_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                setScore();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Spinner disability_verbal_spinner = (Spinner) findViewById(R.id.disability_verbal_spinner);
        ArrayAdapter<CharSequence> disability_verbal_adapter = ArrayAdapter.createFromResource(this,
                R.array.disbility_verbal, android.R.layout.simple_spinner_item);
        disability_verbal_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        disability_verbal_spinner.setAdapter(disability_verbal_adapter);
        disability_verbal_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                setScore();

                /*Object item = arg0.getItemAtPosition(arg2);
                if (item!=null) {
                    //Toast.makeText(Disability.this, item.toString(), Toast.LENGTH_SHORT).show();

                    if (item.toString().equals("Orientated")){
                        verbal_score = 5;
                    }
                    else if (item.toString().equals("Confused")){
                        verbal_score = 4;
                    }
                    else if (item.toString().equals("Inappropriate Words")){
                        verbal_score = 3;
                    }
                    else if (item.toString().equals("Incomprehensible Sounds")){
                        verbal_score = 2;
                    }
                    else if (item.toString().equals("No Response")){
                        verbal_score = 1;
                    }

                    EditText editText_Score = (EditText) findViewById(R.id.editText_Score);
                    editText_Score.setText(Integer.toString(eye_score + verbal_score + motor_score), TextView.BufferType.EDITABLE);
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Spinner disability_motor_spinner = (Spinner) findViewById(R.id.disability_motor_spinner);
        ArrayAdapter<CharSequence> disability_motor_adapter = ArrayAdapter.createFromResource(this,
                R.array.disbility_motor, android.R.layout.simple_spinner_item);
        disability_motor_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        disability_motor_spinner.setAdapter(disability_motor_adapter);
        disability_motor_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                setScore();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

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

    private void setScore() {
        Spinner disability_eye_spinner = (Spinner) findViewById(R.id.disability_eye_spinner);
        if (disability_eye_spinner.getSelectedItem().toString().equals("Open Spontaneously")){
            eye_score = 4;
        }
        else if (disability_eye_spinner.getSelectedItem().toString().equals("Open to Speech")){
            eye_score = 3;
        }
        else if (disability_eye_spinner.getSelectedItem().toString().equals("Open to Pain")){
            eye_score = 2;
        }
        else if (disability_eye_spinner.getSelectedItem().toString().equals("Never Open")){
            eye_score = 1;
        }

        Spinner disability_verbal_spinner = (Spinner) findViewById(R.id.disability_verbal_spinner);
        if (disability_verbal_spinner.getSelectedItem().toString().equals("Orientated")){
            verbal_score = 5;
        }
        else if (disability_verbal_spinner.getSelectedItem().toString().equals("Confused")){
            verbal_score = 4;
        }
        else if (disability_verbal_spinner.getSelectedItem().toString().equals("Inappropriate Words")){
            verbal_score = 3;
        }
        else if (disability_verbal_spinner.getSelectedItem().toString().equals("Incomprehensible Sounds")){
            verbal_score = 2;
        }
        else if (disability_verbal_spinner.getSelectedItem().toString().equals("No Response")){
            verbal_score = 1;
        }

        Spinner disability_motor_spinner = (Spinner) findViewById(R.id.disability_motor_spinner);
        if (disability_motor_spinner.getSelectedItem().toString().equals("Obeys Commands")){
            motor_score = 6;
        }
        else if (disability_motor_spinner.getSelectedItem().toString().equals("Localises to Pain")){
            motor_score = 5;
        }
        else if (disability_motor_spinner.getSelectedItem().toString().equals("Flexion Withdrawal")){
            motor_score = 4;
        }
        else if (disability_motor_spinner.getSelectedItem().toString().equals("Decorticate Flexion")){
            motor_score = 3;
        }
        else if (disability_motor_spinner.getSelectedItem().toString().equals("Decerebrate Extension")){
            motor_score = 2;
        }
        else if (disability_motor_spinner.getSelectedItem().toString().equals("No Response")){
            motor_score = 1;
        }

        EditText editText_Score = (EditText) findViewById(R.id.editText_Score);
        editText_Score.setText(Integer.toString(eye_score + verbal_score + motor_score), TextView.BufferType.EDITABLE);
    }
}

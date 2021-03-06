package uk.nhs.kch.asclepius;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Bloods extends Activity {
    private TextView textView_TimeCodeRedInitiated_Date;
    private ImageButton button_TimeCodeRedInitiated_Date;
    private TextView textView_TimeCodeRedInitiated_Time;
    private ImageButton button_TimeCodeRedInitiated_Time;

    private TextView textView_TimeBloodsTaken_Date;
    private ImageButton button_TimeBloodsTaken_Date;
    private TextView textView_TimeBloodsTaken_Time;
    private ImageButton button_TimeBloodsTaken_Time;

    private int mYear;
    private int mMonth;
    private int mDay;
    private int mhour;
    private int mminute;

    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 1;
    static final int DATE_DIALOG_ID_TIMEBLOODSTAKEN = 2;
    static final int TIME_DIALOG_ID_TIMEBLOODSTAKEN = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloods);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        Spinner bloods_bloodgastype_spinner = (Spinner) findViewById(R.id.bloods_bloodgastype_spinner);
        ArrayAdapter<CharSequence> bloods_bloodgastype_adapter = ArrayAdapter.createFromResource(this,
                R.array.disbility_eye, android.R.layout.simple_spinner_item);
        bloods_bloodgastype_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        bloods_bloodgastype_spinner.setAdapter(bloods_bloodgastype_adapter);

        textView_TimeCodeRedInitiated_Date = (TextView) findViewById(R.id.textView_TimeCodeRedInitiated_Date);
        button_TimeCodeRedInitiated_Date = (ImageButton) findViewById(R.id.button_TimeCodeRedInitiated_Date);
        textView_TimeCodeRedInitiated_Time = (TextView) findViewById(R.id.textView_TimeCodeRedInitiated_Time);
        button_TimeCodeRedInitiated_Time = (ImageButton) findViewById(R.id.button_TimeCodeRedInitiated_Time);

        button_TimeCodeRedInitiated_Date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        button_TimeCodeRedInitiated_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });

        textView_TimeBloodsTaken_Date = (TextView) findViewById(R.id.textView_TimeBloodsTaken_Date);
        button_TimeBloodsTaken_Date = (ImageButton) findViewById(R.id.button_TimeBloodsTaken_Date);
        textView_TimeBloodsTaken_Time = (TextView) findViewById(R.id.textView_TimeBloodsTaken_Time);
        button_TimeBloodsTaken_Time = (ImageButton) findViewById(R.id.button_TimeBloodsTaken_Time);

        button_TimeBloodsTaken_Date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID_TIMEBLOODSTAKEN);
            }
        });

        button_TimeBloodsTaken_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID_TIMEBLOODSTAKEN);
            }
        });

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mhour = c.get(Calendar.HOUR_OF_DAY);
        mminute = c.get(Calendar.MINUTE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bloods, menu);
        return true;
    }

    public void onButtonClick_Next(View view){
        Intent intent = new Intent(this, FastScan.class);
        startActivity(intent);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener1, mYear, mMonth, mDay);
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this, mTimeSetListener1, mhour, mminute, false);
            case DATE_DIALOG_ID_TIMEBLOODSTAKEN:
                return new DatePickerDialog(this, mDateSetListener2, mYear, mMonth, mDay);
            case TIME_DIALOG_ID_TIMEBLOODSTAKEN:
                return new TimePickerDialog(this, mTimeSetListener2, mhour, mminute, false);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener1 =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDate1();
                }
            };

    private TimePickerDialog.OnTimeSetListener mTimeSetListener1 =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    mhour = hourOfDay;
                    mminute = minute;
                    updatetime1();
                }
            };

    private void updateDate1() {
        textView_TimeCodeRedInitiated_Date.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mDay).append("/")
                        .append(mMonth + 1).append("/")
                        .append(mYear).append(" "));
        showDialog(TIME_DIALOG_ID);

    }

    public void updatetime1(){
        textView_TimeCodeRedInitiated_Time.setText(
                new StringBuilder()
                        .append(pad(mhour)).append(":")
                        .append(pad(mminute)));
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener2 =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDate2();
                }
            };

    private TimePickerDialog.OnTimeSetListener mTimeSetListener2 =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    mhour = hourOfDay;
                    mminute = minute;
                    updatetime2();
                }
            };

    private void updateDate2() {
        textView_TimeBloodsTaken_Date.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mDay).append("/")
                        .append(mMonth + 1).append("/")
                        .append(mYear).append(" "));
        showDialog(TIME_DIALOG_ID_TIMEBLOODSTAKEN);

    }

    public void updatetime2(){
        textView_TimeBloodsTaken_Time.setText(
                new StringBuilder()
                        .append(pad(mhour)).append(":")
                        .append(pad(mminute)));
    }

    private static String pad(int c) {
        if (c >= 10){
            return String.valueOf(c);
        }
        else{
            return "0" + String.valueOf(c);
        }
    }
}

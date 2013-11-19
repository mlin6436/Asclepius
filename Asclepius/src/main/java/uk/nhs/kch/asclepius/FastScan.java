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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class FastScan extends Activity {
    private TextView textView_TimeCTOrdered_Date;
    private ImageButton button_TimeCTOrdered_Date;
    private TextView textView_TimeCTOrdered_Time;
    private ImageButton button_TimeCTOrdered_Time;

    private TextView textView_TimePatientInCT_Date;
    private ImageButton button_TimePatientInCT_Date;
    private TextView textView_TimePatientInCT_Time;
    private ImageButton button_TimePatientInCT_Time;

    private int mYear;
    private int mMonth;
    private int mDay;
    private int mhour;
    private int mminute;

    static final int DATE_DIALOG_ID_TimeCTOrdered = 0;
    static final int TIME_DIALOG_ID_TimeCTOrdered = 1;
    static final int DATE_DIALOG_ID_TimePatientInCT = 2;
    static final int TIME_DIALOG_ID_TimePatientInCT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastscan);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        textView_TimeCTOrdered_Date = (TextView) findViewById(R.id.textView_TimeCTOrdered_Date);
        button_TimeCTOrdered_Date = (ImageButton) findViewById(R.id.button_TimeCTOrdered_Date);
        textView_TimeCTOrdered_Time = (TextView) findViewById(R.id.textView_TimeCTOrdered_Time);
        button_TimeCTOrdered_Time = (ImageButton) findViewById(R.id.button_TimeCTOrdered_Time);

        button_TimeCTOrdered_Date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID_TimeCTOrdered);
            }
        });

        button_TimeCTOrdered_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID_TimeCTOrdered);
            }
        });

        textView_TimePatientInCT_Date = (TextView) findViewById(R.id.textView_TimePatientInCT_Date);
        button_TimePatientInCT_Date = (ImageButton) findViewById(R.id.button_TimePatientInCT_Date);
        textView_TimePatientInCT_Time = (TextView) findViewById(R.id.textView_TimePatientInCT_Time);
        button_TimePatientInCT_Time = (ImageButton) findViewById(R.id.button_TimePatientInCT_Time);

        button_TimePatientInCT_Date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID_TimePatientInCT);
            }
        });

        button_TimePatientInCT_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID_TimePatientInCT);
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
        getMenuInflater().inflate(R.menu.fast_scan, menu);
        return true;
    }

    public void onButtonClick_Next(View view){
        Intent intent = new Intent(this, Summary.class);
        startActivity(intent);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID_TimeCTOrdered:
                return new DatePickerDialog(this, mDateSetListener1, mYear, mMonth, mDay);
            case TIME_DIALOG_ID_TimeCTOrdered:
                return new TimePickerDialog(this, mTimeSetListener1, mhour, mminute, false);
            case DATE_DIALOG_ID_TimePatientInCT:
                return new DatePickerDialog(this, mDateSetListener2, mYear, mMonth, mDay);
            case TIME_DIALOG_ID_TimePatientInCT:
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
        textView_TimeCTOrdered_Date.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mDay).append("/")
                        .append(mMonth + 1).append("/")
                        .append(mYear).append(" "));
        showDialog(TIME_DIALOG_ID_TimeCTOrdered);

    }

    public void updatetime1(){
        textView_TimeCTOrdered_Time.setText(
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
        textView_TimePatientInCT_Date.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mDay).append("/")
                        .append(mMonth + 1).append("/")
                        .append(mYear).append(" "));
        showDialog(TIME_DIALOG_ID_TimePatientInCT);

    }

    public void updatetime2(){
        textView_TimePatientInCT_Time.setText(
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

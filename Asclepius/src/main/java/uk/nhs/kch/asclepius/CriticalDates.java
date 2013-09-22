package uk.nhs.kch.asclepius;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class CriticalDates extends Activity {
    private TextView textView_DateOfIncident_Date;
    private Button button_dateOfIncident_Date;
    private TextView textView_DateOfIncident_Time;
    private Button button_dateOfIncident_Time;

    private TextView textView_ArrivedAtScene_Date;
    private Button button_ArrivedAtScene_Date;
    private TextView textView_ArrivedAtScene_Time;
    private Button button_ArrivedAtScene_Time;

    private TextView textView_DepartedScene_Date;
    private Button button_DepartedScene_Date;
    private TextView textView_DepartedScene_Time;
    private Button button_DepartedScene_Time;

    private TextView textView_ArrivedAtMajorTraumaCentre_Date;
    private Button button_ArrivedAtMajorTraumaCentre_Date;
    private TextView textView_ArrivedAtMajorTraumaCentre_Time;
    private Button button_ArrivedAtMajorTraumaCentre_Time;

    private int mYear;
    private int mMonth;
    private int mDay;
    private int mhour;
    private int mminute;

    static final int DATE_DIALOG_ID_DATEOFINCIDENT = 0;
    static final int TIME_DIALOG_ID_DATEOFINCIDENT = 1;
    static final int DATE_DIALOG_ID_ARRIVEDATSCENE = 2;
    static final int TIME_DIALOG_ID_ARRIVEDATSCENE = 3;
    static final int DATE_DIALOG_ID_DEPARTEDSCENE = 4;
    static final int TIME_DIALOG_ID_DEPARTEDSCENE = 5;
    static final int DATE_DIALOG_ID_ArrivedAtMajorTraumaCentre = 6;
    static final int TIME_DIALOG_ID_ArrivedAtMajorTraumaCentre = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criticaldates);

        textView_DateOfIncident_Date = (TextView) findViewById(R.id.textView_DateOfIncident_Date);
        button_dateOfIncident_Date = (Button) findViewById(R.id.button_DateOfIncident_Date);
        textView_DateOfIncident_Time = (TextView) findViewById(R.id.textView_DateOfIncident_Time);
        button_dateOfIncident_Time = (Button) findViewById(R.id.button_DateOfIncident_Time);

        button_dateOfIncident_Date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID_DATEOFINCIDENT);
            }
        });

        button_dateOfIncident_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID_DATEOFINCIDENT);
            }
        });

        textView_ArrivedAtScene_Date = (TextView) findViewById(R.id.textView_ArrivedAtScene_Date);
        button_ArrivedAtScene_Date = (Button) findViewById(R.id.button_ArrivedAtScene_Date);
        textView_ArrivedAtScene_Time = (TextView) findViewById(R.id.textView_ArrivedAtScene_Time);
        button_ArrivedAtScene_Time = (Button) findViewById(R.id.button_ArrivedAtScene_Time);

        button_ArrivedAtScene_Date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID_ARRIVEDATSCENE);
            }
        });

        button_ArrivedAtScene_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID_ARRIVEDATSCENE);
            }
        });

        textView_DepartedScene_Date = (TextView) findViewById(R.id.textView_DepartedScene_Date);
        button_DepartedScene_Date = (Button) findViewById(R.id.button_DepartedScene_Date);
        textView_DepartedScene_Time = (TextView) findViewById(R.id.textView_DepartedScene_Time);
        button_DepartedScene_Time = (Button) findViewById(R.id.button_DepartedScene_Time);

        button_DepartedScene_Date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID_DEPARTEDSCENE);
            }
        });

        button_DepartedScene_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID_DEPARTEDSCENE);
            }
        });

        textView_ArrivedAtMajorTraumaCentre_Date = (TextView) findViewById(R.id.textView_ArrivedAtMajorTraumaCentre_Date);
        button_ArrivedAtMajorTraumaCentre_Date = (Button) findViewById(R.id.button_ArrivedAtMajorTraumaCentre_Date);
        textView_ArrivedAtMajorTraumaCentre_Time = (TextView) findViewById(R.id.textView_ArrivedAtMajorTraumaCentre_Time);
        button_ArrivedAtMajorTraumaCentre_Time = (Button) findViewById(R.id.button_ArrivedAtMajorTraumaCentre_Time);

        button_ArrivedAtMajorTraumaCentre_Date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID_ArrivedAtMajorTraumaCentre);
            }
        });

        button_ArrivedAtMajorTraumaCentre_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID_ArrivedAtMajorTraumaCentre);
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
        getMenuInflater().inflate(R.menu.critical_dates, menu);
        return true;
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID_DATEOFINCIDENT:
                return new DatePickerDialog(this, mDateSetListener1, mYear, mMonth, mDay);
            case TIME_DIALOG_ID_DATEOFINCIDENT:
                return new TimePickerDialog(this, mTimeSetListener1, mhour, mminute, false);
            case DATE_DIALOG_ID_ARRIVEDATSCENE:
                return new DatePickerDialog(this, mDateSetListener2, mYear, mMonth, mDay);
            case TIME_DIALOG_ID_ARRIVEDATSCENE:
                return new TimePickerDialog(this, mTimeSetListener2, mhour, mminute, false);
            case DATE_DIALOG_ID_DEPARTEDSCENE:
                return new DatePickerDialog(this, mDateSetListener3, mYear, mMonth, mDay);
            case TIME_DIALOG_ID_DEPARTEDSCENE:
                return new TimePickerDialog(this, mTimeSetListener3, mhour, mminute, false);
            case DATE_DIALOG_ID_ArrivedAtMajorTraumaCentre:
                return new DatePickerDialog(this, mDateSetListener4, mYear, mMonth, mDay);
            case TIME_DIALOG_ID_ArrivedAtMajorTraumaCentre:
                return new TimePickerDialog(this, mTimeSetListener4, mhour, mminute, false);
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
        textView_DateOfIncident_Date.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mDay).append("/")
                        .append(mMonth + 1).append("/")
                        .append(mYear).append(" "));
        showDialog(TIME_DIALOG_ID_DATEOFINCIDENT);

    }

    public void updatetime1(){
        textView_DateOfIncident_Time.setText(
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
        textView_ArrivedAtScene_Date.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mDay).append("/")
                        .append(mMonth + 1).append("/")
                        .append(mYear).append(" "));
        showDialog(TIME_DIALOG_ID_ARRIVEDATSCENE);

    }

    public void updatetime2() {
        textView_ArrivedAtScene_Time.setText(
                new StringBuilder()
                        .append(pad(mhour)).append(":")
                        .append(pad(mminute)));
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener3 =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDate3();
                }
            };

    private TimePickerDialog.OnTimeSetListener mTimeSetListener3 =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    mhour = hourOfDay;
                    mminute = minute;
                    updatetime3();
                }
            };

    private void updateDate3() {
        textView_DepartedScene_Date.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mDay).append("/")
                        .append(mMonth + 1).append("/")
                        .append(mYear).append(" "));
        showDialog(TIME_DIALOG_ID_DEPARTEDSCENE);

    }

    public void updatetime3() {
        textView_DepartedScene_Time.setText(
                new StringBuilder()
                        .append(pad(mhour)).append(":")
                        .append(pad(mminute)));
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener4 =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDate4();
                }
            };

    private TimePickerDialog.OnTimeSetListener mTimeSetListener4 =
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    mhour = hourOfDay;
                    mminute = minute;
                    updatetime4();
                }
            };

    private void updateDate4() {
        textView_ArrivedAtMajorTraumaCentre_Date.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mDay).append("/")
                        .append(mMonth + 1).append("/")
                        .append(mYear).append(" "));
        showDialog(TIME_DIALOG_ID_ArrivedAtMajorTraumaCentre);

    }

    public void updatetime4() {
        textView_ArrivedAtMajorTraumaCentre_Time.setText(
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

    public void onButtonClick_Next(View view){
        Intent intent = new Intent(this, Airway.class);
        startActivity(intent);
    }
}

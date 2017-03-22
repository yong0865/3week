package com.example.yo.a3week;

import android.app.TimePickerDialog;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main3Activity extends AppCompatActivity {
    Switch start;
    Chronometer timer;
    FrameLayout frame1;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView t15, t17, t19, t21, t23;
    Button backb, nextb;
    TableRow tableb;
    GridLayout grid1, grid2;
    EditText e1, e2, e3;
    int menuIndex;


    public void changemenu() {
        if (menuIndex == 0) {
            backb.setEnabled(false);
            nextb.setEnabled(true);
            datePicker.setVisibility(View.VISIBLE);
            timePicker.setVisibility(View.GONE);
            grid1.setVisibility(View.GONE);
            grid2.setVisibility(View.GONE);
        } else if (menuIndex == 1) {
            backb.setEnabled(true);
            nextb.setEnabled(true);
            datePicker.setVisibility(View.GONE);
            timePicker.setVisibility(View.VISIBLE);
            grid1.setVisibility(View.GONE);
            grid2.setVisibility(View.GONE);
        } else if (menuIndex == 2) {
            t17.setText(Integer.toString(timePicker.getCurrentHour()) + "시 " + Integer.toString(timePicker.getCurrentMinute()) + "분");
            backb.setEnabled(true);
            nextb.setEnabled(true);
            datePicker.setVisibility(View.GONE);
            timePicker.setVisibility(View.GONE);
            grid1.setVisibility(View.VISIBLE);
            grid2.setVisibility(View.GONE);

        } else if (menuIndex == 3) {
            String adult = e1.getText().toString();
            String middle = e2.getText().toString();
            String baby = e3.getText().toString();
            if (adult.getBytes().length == 0) e1.setText("0명");
            {
                adult = e1.getText().toString();
            }
            if (middle.getBytes().length == 0) e2.setText("0명");
            {
                middle = e2.getText().toString();
            }
            if (baby.getBytes().length == 0) e3.setText("0명");
            {
                baby = e3.getText().toString();
            }

            t19.setText(adult + "명");
            t21.setText(middle + "명");
            t23.setText(baby + "명");
            backb.setEnabled(true);
            nextb.setEnabled(false);
            datePicker.setVisibility(View.GONE);
            timePicker.setVisibility(View.GONE);
            grid1.setVisibility(View.GONE);
            grid2.setVisibility(View.VISIBLE);

        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nextb:
                if (menuIndex < 3) {
                    menuIndex++;
                }
                changemenu();
                break;
            case R.id.backb:
                if (menuIndex > 0) {
                    menuIndex--;
                }

                changemenu();

                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        frame1 = (FrameLayout) findViewById(R.id.frame1);
        timer = (Chronometer) findViewById(R.id.timer);
        start = (Switch) findViewById(R.id.start);
        backb = (Button) findViewById(R.id.backb);
        nextb = (Button) findViewById(R.id.nextb);
        t15 = (TextView) findViewById(R.id.t15);
        t17 = (TextView) findViewById(R.id.t17);
        t19 = (TextView) findViewById(R.id.t19);
        t21 = (TextView) findViewById(R.id.t21);
        t23 = (TextView) findViewById(R.id.t23);

        tableb = (TableRow) findViewById(R.id.tableb);
        grid1 = (GridLayout) findViewById(R.id.grid1);
        grid2 = (GridLayout) findViewById(R.id.grid2);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);


        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                t15.setText(year + "년 " + (monthOfYear + 1) + "월 " + dayOfMonth + "일");
            }

        });


        start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (isChecked == true) {
                    nextb.setEnabled(true);
                    frame1.setVisibility(View.VISIBLE);
                    tableb.setVisibility(View.VISIBLE);
                    datePicker.setVisibility(View.VISIBLE);
                    timer.setVisibility(View.VISIBLE);
                    timer.setBase(SystemClock.elapsedRealtime());
                    timer.setFormat("예약시작 경과 시간 : %s");
                    timer.start();


                } else {
                    timer.setVisibility(View.GONE);
                    timePicker.setVisibility(View.GONE);
                    frame1.setVisibility(View.GONE);
                    Calendar calendar = Calendar.getInstance();
                    timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
                    timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
                    datePicker.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                    tableb.setVisibility(View.GONE);
                    grid1.setVisibility(View.GONE);
                    grid2.setVisibility(View.GONE);
                    e1.setText(null);
                    e2.setText(null);
                    e3.setText(null);
                    menuIndex = 0;


                }
            }
        });


    }
}

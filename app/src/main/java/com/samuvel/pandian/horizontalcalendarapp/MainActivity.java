package com.samuvel.pandian.horizontalcalendarapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.samuvel.pandian.horizontalcalendar.DayDateMonthModel;
import com.samuvel.pandian.horizontalcalendar.HorizontalCalendarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HorizontalCalendarView.HorizontalCalendarListener {
    HorizontalCalendarView horizontalCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        horizontalCalendarView = findViewById(R.id.horizontalCalenderView);
        horizontalCalendarView.setHorizontalCalendarListener(this);
    }

    @Override
    public void onCalendarSwiped(ArrayList<String> dates) {
        for (String date : dates) {
            Log.d("HorizontalDates", date);
        }
    }

    @Override
    public void onDaySelected(DayDateMonthModel dayDateMonthModel) {
        Toast.makeText(getApplicationContext(), dayDateMonthModel.date, Toast.LENGTH_SHORT).show();
    }
}

package com.ateam.projectapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;




public class FoodEntry extends Activity{
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
     setContentView(R.layout.foodentry);
    CalendarView calendarView=(CalendarView) findViewById(R.id.CalView);
    calendarView.setOnDateChangeListener(new OnDateChangeListener() {

        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month,
                int dayOfMonth) {
        	
        	Intent calintent = new Intent();
			calintent.setClass(FoodEntry.this, Meals.class);
			FoodEntry.this.startActivity(calintent);
			
        	
           Toast.makeText(getApplicationContext(), ""+dayOfMonth, 0).show();// TODO Auto-generated method stub

        }
    });
}}
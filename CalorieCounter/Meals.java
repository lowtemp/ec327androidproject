package com.ateam.projectapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Meals extends ActionBarActivity implements OnClickListener {

	CheckBox checkBox;
    EditText editText1;
    Button button1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    EditText editText8;
    TextView textView1;
    Button button2;

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                    return true;
            }
            return super.onOptionsItemSelected(item);
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.meals);
		button1 = (Button) findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.edittext5);
        editText6 = (EditText) findViewById(R.id.edittext6);
        editText7 = (EditText) findViewById(R.id.edittext7);
        editText8 = (EditText) findViewById(R.id.edittext8);
        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        textView1 = (TextView) findViewById(R.id.textView1);
        button2 = (Button) findViewById(R.id.button2);
       
        button1.setOnClickListener((OnClickListener) this);
        button2.setOnClickListener((OnClickListener)this);
    loadSavedPreferences();
	}
	
	
	
	private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean checkBoxValue = sharedPreferences.getBoolean("CheckBox_Value", false);
        
        
        String breakfast = sharedPreferences.getString("storedBreakf", "Breakfast");
        String lunch = sharedPreferences.getString("storedLunch", "Lunch");
        String dinner = sharedPreferences.getString("storedDinner", "Dinner");
        String snacks = sharedPreferences.getString("storedSnacks", "Snacks");
        String calb = sharedPreferences.getString("storedCalb", "Calories");
        String call = sharedPreferences.getString("storedCall", "Calories");
        String cald = sharedPreferences.getString("storedCald", "Calories");
        String cals = sharedPreferences.getString("storedCals", "Calories");        
       
        if (checkBoxValue) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        editText1.setText(breakfast);
        editText2.setText(lunch);
        editText3.setText(dinner);
        editText4.setText(snacks);
        editText5.setText(calb);
        editText6.setText(call);
        editText7.setText(cald);
        editText8.setText(cals);
    }
        
    private void savePreferences(String key1, boolean value1) {
        SharedPreferences sharedPreferences = PreferenceManager
        		.getDefaultSharedPreferences(this);
        Editor editor = sharedPreferences.edit();
        editor.putBoolean(key1, value1);
        editor.commit();
    }
    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public void onClick(View v) {
    	        // TODO Auto-generated method stub
    	    	if (v == button1)
    	    	{
    	    		savePreferences("CheckBox_Value", checkBox.isChecked());
    	    		if (checkBox.isChecked())
    	    		{
    	    			savePreferences("storedBreakf", editText1.getText().toString());
    	    			savePreferences("storedLunch", editText2.getText().toString());
    	    			savePreferences("storedDinner", editText3.getText().toString());
    	    			savePreferences("storedSnacks", editText4.getText().toString());
    	    			savePreferences("storedCalb", editText5.getText().toString());
    	    			savePreferences("storedCall", editText6.getText().toString());
    	    			savePreferences("storedCald", editText7.getText().toString());
    	    			savePreferences("storedCals", editText8.getText().toString());
    	    		}
    	    		finish();
    	        }
    	        else if (v == button2)
    	        {
        	        double cals = 1724.9375;
        	        textView1.setText("Calories Left: " + cals);
    	        }
    	        }
    }

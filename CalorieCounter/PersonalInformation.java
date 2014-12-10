package com.ateam.projectapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class PersonalInformation extends Activity implements OnClickListener {
    CheckBox checkBox;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    SeekBar seekBar;
   TextView textView1;
    TextView textView2;
    TextView textView3;
    Button button;
    Button buttonc;
    int el;
    double BMR;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalinformation);
        
        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        seekBar = (SeekBar) findViewById(R.id.seekbar1);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        buttonc = (Button) findViewById(R.id.buttonc);
        button = (Button) findViewById(R.id.button1);
        
        button.setOnClickListener(this);
        buttonc.setOnClickListener(this);
       loadSavedPreferences();
                
                textView1.setText("Covered: " + seekBar.getProgress() + "/" + seekBar.getMax());
                
                seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
        int progress = 0;
        
        
                        
        @Override
        public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
        progress = progresValue;
        Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
                }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        textView1.setText("Covered: " + progress + "/" + seekBar.getMax());
        Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
                                  }
                });
    }
    
    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean checkBoxValue = sharedPreferences.getBoolean("CheckBox_Value", false);
        
        
        String height = sharedPreferences.getString("storedHeight", "Your Height");
        String weight = sharedPreferences.getString("storedWeight", "Your Weight");
        String age = sharedPreferences.getString("storedAge", "Your Age");
        String gender = sharedPreferences.getString("storedGender", "Your Gender");
        String calIn = sharedPreferences.getString("storedCal", "Your Cal");
        
       
        if (checkBoxValue) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        editText1.setText(height);
        editText2.setText(weight);
        editText3.setText(age);
        editText4.setText(gender);
    }
        
        
       
    private void savePreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
    	if (v == button)
    	{
        savePreferences("CheckBox_Value", checkBox.isChecked());
        if (checkBox.isChecked())
        {
        	savePreferences("storedHeight", editText1.getText().toString());
        	savePreferences("storedWeight", editText2.getText().toString());
        	savePreferences("storedAge", editText3.getText().toString());
        	savePreferences("storedGender", editText4.getText().toString());
        	savePreferences("storedCal", textView2.getText().toString());
        	finish();
        }
    	}
        else if (v == buttonc)
        {
        	equalclicked(v);
        }
        }

    
    public void equalclicked(View v) {

        /*SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        
        String height = sharedPreferences.getString("storedHeight", "Your Height");
        String weight = sharedPreferences.getString("storedWeight", "Your Weight");
        String age = sharedPreferences.getString("storedAge", "Your Age");
        String gender = sharedPreferences.getString("storedGender", "Your Gender");
        String calIn = sharedPreferences.getString("storedCal", "Your Cal");*/
        String weight = "100";
        String age = "25";
        String gender = "F";
        String height = "60";
        
        int h = Integer.parseInt(height);
        int w = Integer.parseInt(weight);
        int a = Integer.parseInt(age);
        

       BMR = 1;
                if(gender == "F")
                {
                        BMR = 655 + (4.35 * w) + (4.7 * h) - (4.7 * a);
                        textView3.setText("This is the BMR: " + BMR);
                }
                
                else if(gender == "M")
                {
                        BMR = 66 + (6.32 * w) + (12.7 * h) - (6.8 * a);
                        textView3.setText("This is the BMR: " + BMR);
                }
                else
                {
                	BMR = 655 + (4.35 * w) + (4.7 * h) - (4.7 * a);
                	textView3.setText("This is the bmr that you don't have");
                        System.out.print("Wrong inputs. Please enter correct numbers");
                }
         
                double calintake = 0;
                el = seekBar.getProgress();
                switch(el){
                case 1: {calintake = BMR * 1.2;
                textView2.setText("Calories you should eat today: " + calintake);}
                break;
                case 2:{ calintake = BMR * 1.375;
                textView2.setText("Calories you should eat today: " + calintake);}
                break;
                case 3: {calintake = BMR * 1.55;
                textView2.setText("Calories you should eat today: " + calintake);}
                break;
                case 4: {calintake =  BMR * 1.725;
                textView2.setText("Calories you should eat today: " + calintake);}
                break;
                case 5: {calintake = BMR * 1.9;
                textView2.setText("Calories you should eat today: " + calintake);}
                break;
                default: {calintake = 2000;
                textView2.setText("Calories you should eat today: " + calintake);}
                break;          
                }
                     
        }
    }

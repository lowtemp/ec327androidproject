package com.ateam.projectapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

	Button one;
	Button two;
	Button three;
	Button four;
	Button five;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        one=(Button)findViewById(R.id.button1);
        two=(Button)findViewById(R.id.button2);
        three=(Button)findViewById(R.id.button3);
        four=(Button)findViewById(R.id.button4);
        five=(Button)findViewById(R.id.button5);
        
        one.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//if(v == one)
				//{
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, FoodEntry.class);
					MainActivity.this.startActivity(intent);
					
					
				//}
			}
				});
			
		two.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//if(v == two){
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, InspirationBoard.class);
					MainActivity.this.startActivity(intent);
				//}
			}
		});
		
		three.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//if(v == three){
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ProgressGraphs.class);
				MainActivity.this.startActivity(intent);
				//}
			}
		});
		
		four.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//if(v == four){
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, PersonalInformation.class);
				MainActivity.this.startActivity(intent);
				//}
			}
		});
		
		five.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//if(v == five){
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, Help.class);
				MainActivity.this.startActivity(intent);
		//}
	}
});
		
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

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
}

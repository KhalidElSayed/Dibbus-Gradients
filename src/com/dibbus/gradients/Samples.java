package com.dibbus.gradients;

import adapters.ButtonAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.Spinner;

public class Samples extends Activity {

    private Spinner spinner1;
	private Spinner spinner2;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if(getIntent().getStringExtra("template").equals("basic")){
        	setContentView(R.layout.activity_basic_buttons);
        } else if(getIntent().getStringExtra("template").equals("9patch")){
        	setContentView(R.layout.activity_buttons_nine_patch);
        } else if(getIntent().getStringExtra("template").equals("matte")){
        	setContentView(R.layout.activity_buttons_matte);
        } else if(getIntent().getStringExtra("template").equals("apple")){
        	setContentView(R.layout.activity_buttons_apple);
        } else if(getIntent().getStringExtra("template").equals("advanced")){
        	setContentView(R.layout.activity_advanced);
        	
        	spinner1 = (Spinner) findViewById(R.id.spinner1);        	
        	spinner1.setSelection(3);
        	spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					SetSpinnerValues();
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
        		
			});


        	spinner2 = (Spinner) findViewById(R.id.spinner2);
        	spinner2.setSelection(4);        	
        	spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					SetSpinnerValues();
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
        		
			});
        	
        	ListView gridview = (ListView) findViewById(R.id.listView1);
    		gridview.setAdapter(new ButtonAdapter(this, "ad"));
        	
        } else {
        	setContentView(R.layout.activity_splash);
        }          
        
    }
    
    private void SetSpinnerValues(){
    	String selected1 = spinner1.getSelectedItem().toString();
    	String selected2 = spinner2.getSelectedItem().toString();
    	
    	ListView gridview = (ListView) findViewById(R.id.listView1);
    	
    	ButtonAdapter ba = new ButtonAdapter(this, selected1 + selected2);
    	ba.notifyDataSetChanged();
		gridview.setAdapter(ba);
    	
    }
    
}

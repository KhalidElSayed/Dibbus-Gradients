package com.dibbus.gradients;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.support.v4.app.NavUtils;
import com.google.ads.*;


public class Splash extends Activity {

	private AdView adView;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);              
        setContentView(R.layout.activity_splash);
        
        // Create the adView
        adView = new AdView(this, AdSize.BANNER, "a1503f5a9277723");

        // Lookup your LinearLayout assuming it's been given
        // the attribute android:id="@+id/mainLayout"
        LinearLayout layout = (LinearLayout)findViewById(R.id.llAdmob);

        // Add the adView to it
        layout.addView(adView);

        AdRequest adRequest = new AdRequest();        
        adRequest.addTestDevice("36924ad422861fce");     
        
        // Initiate a generic request to load it with an ad
        adView.loadAd(adRequest);

    }
    
    @Override
    public void onDestroy() {
      if (adView != null) {
        adView.destroy();
      }
      super.onDestroy();
    }

    
    public void button_basic_click(View v) {
    	Intent i = new Intent(Splash.this, Samples.class);
    	Button b = (Button) v;
    	i.putExtra("template", b.getTag().toString());
		startActivity(i);
	}
    
}

package adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import classes.GradientColor;
import classes.GradientTypes;
import classes.Gradients;

public class ButtonAdapter extends BaseAdapter {
    private Context mContext;
    private String gradientType;

    public ButtonAdapter(Context c, String type) {
        mContext = c;
        this.gradientType = type;
    }

    public int getCount() {
        return Gradients.AllGradients().size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @SuppressWarnings("deprecation")
	public View getView(int position, View convertView, ViewGroup parent) {
        final Button b;
        
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, 150);
        
        
        if (convertView == null) {
            b = new Button(mContext);
            b.setLayoutParams(lp);            
            b.setPadding(12, 12, 12, 12);
            b.setTextSize(20f);      
        } else {
            b = (Button) convertView;
        }
        
        final GradientColor gd = Gradients.AllGradients().get(position);
        
        int firstColor = gd.getColorA();
        int secondColor = gd.getColorD();
        char firstVal = this.gradientType.charAt(0);
        char secondVal = this.gradientType.charAt(1);
     
        
        if(firstVal == 'a'){
        	firstColor = gd.getColorA();
        } else if(firstVal == 'b'){
        	firstColor = gd.getColorB();
        } else if(firstVal == 'c'){
        	firstColor = gd.getColorC();
        } else if(firstVal == 'd'){
        	firstColor = gd.getColorD();
        } else if(firstVal == 'e'){
        	firstColor = gd.getColorE();
        }
        
        if(secondVal == 'a'){
        	secondColor = gd.getColorA();
        } else if(secondVal == 'b'){
        	secondColor = gd.getColorB();
        } else if(secondVal == 'c'){
        	secondColor = gd.getColorC();
        } else if(secondVal == 'd'){
        	secondColor = gd.getColorD();
        } else if(secondVal == 'e'){
        	secondColor = gd.getColorE();
        }
               
        b.setBackgroundDrawable(Gradients.NewGradient(gd, firstColor, secondColor));
        b.setText(Html.fromHtml(gd.getName() + "<br/>From #" + Integer.toHexString(firstColor).substring(2) + " to #" +  Integer.toHexString(secondColor).substring(2)));
        b.setTextColor(Color.WHITE); 
        b.setTypeface(null, Typeface.BOLD);
        b.setShadowLayer(2f, 2f, 2f, Color.BLACK);
        
        final int fc = firstColor;
        final int sc = secondColor;
        
		b.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() != MotionEvent.ACTION_UP) {
					b.setBackgroundDrawable(Gradients.NewGradient(gd, sc, fc));
				} else {
					b.setBackgroundDrawable(Gradients.NewGradient(gd, fc, sc));
				}
				return false;

			}
		});
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("message/rfc822");
				//i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
				i.putExtra(Intent.EXTRA_SUBJECT, "Xml code for an Android button");
				i.putExtra(Intent.EXTRA_TEXT   , helpers.EmailHelper.WriteButtonXml(Integer.toHexString(fc).substring(2), Integer.toHexString(sc).substring(2)));
				try {
				    mContext.startActivity(Intent.createChooser(i, "Send xml of the button..."));
				} catch (android.content.ActivityNotFoundException ex) {
				    Toast.makeText(mContext, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
				}

			}
		});
        
        return b;
    }    
}
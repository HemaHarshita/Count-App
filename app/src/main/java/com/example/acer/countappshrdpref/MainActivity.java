package com.example.acer.countappshrdpref;

import android.app.Notification;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btnb,btnr,btnbl,btng;
    int s=0;
    private int colorCode;
    SharedPreferences sp;
    private String spFileName="com.example.acer.countappshrdpref";
    private String countkey="countkey";
    private String colorkey="colorkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        textView=findViewById (R.id.txtview);
        btnb=findViewById (R.id.btn1);
        btnr=findViewById (R.id.btn2);
        btnbl=findViewById (R.id.btn3);
        btng=findViewById (R.id.btn4);
        sp=getSharedPreferences (spFileName,MODE_PRIVATE);

                s = sp.getInt (countkey,0);
                 colorCode = sp.getInt (colorkey,1);
        if(s!=0){
                textView.setText (String.valueOf (s));
                textView.setBackgroundColor (colorCode);
                
            }
        }




    public void btnCount(View view) {
        s++;
        textView.setText (String.valueOf (s));


    }

    public void btnReset(View view) {
        s=0;
        textView.setText (""+s);

    }

    public void btnBlack(View view) {
        colorCode=getResources ().getColor (R.color.black);
        textView.setBackgroundColor (colorCode);



    }

    public void btnRed(View view) {
       colorCode=getResources ().getColor (R.color.red);
        textView.setBackgroundColor (colorCode);



    }

    public void btnBlue(View view) {
        colorCode=getResources ().getColor (R.color.blue);
        textView.setBackgroundColor (colorCode);

    }

    public void btnGreen(View view) {
        colorCode=getResources ().getColor (R.color.green);
        textView.setBackgroundColor (colorCode);

    }

    @Override
    protected void onPause() {
        super.onPause ();
        s= Integer.parseInt (textView.getText ().toString ());
       // colorCode= Integer.parseInt (textView.getBackground ().toString ());
        SharedPreferences.Editor editor= sp.edit ();
        editor.putInt (countkey,s);
        editor.putInt (colorkey,colorCode);
        editor.apply ();
        Toast.makeText (this, "count : "+s+"\ncolor"+colorCode+"\n Successfully saved in Shared Preferences", Toast.LENGTH_SHORT).show ();
    }
}

package com.example.bartomiej.trololoapp;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    public long currentTime;
    private Chronometer chronometer;
    private boolean stopped;
    Button mainButton;
    TextView ms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mainButton= (Button) findViewById(R.id.mainButton);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        ms = (TextView) findViewById(R.id.highscore);
        mainButton.setBackgroundColor(getResources().getColor(R.color.green));
        mainButton.setText("Start!");
        stopped=true;
        currentTime=0;
    }

    public void pressButton(View view)
    {
        if(stopped){
            red();
        }
        else {
            green();
        }
    }
    public void red(){
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        mainButton.setBackgroundColor(getResources().getColor(R.color.red));
        mainButton.setText("Stop!");
        stopped=false;
    }
    public void green(){
        currentTime = chronometer.getBase() - SystemClock.elapsedRealtime();
        long milis = currentTime%1000;
        ms.setText(Math.abs(milis)+" ms");
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());
        stopped=true;
        mainButton.setBackgroundColor(getResources().getColor(R.color.green));
        mainButton.setText("GO!");
        currentTime=0;
    }

}

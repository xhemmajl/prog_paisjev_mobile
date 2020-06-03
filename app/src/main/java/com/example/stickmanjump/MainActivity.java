package com.example.stickmanjump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private GameView pamjaLojes;
    private Handler handler = new Handler();
    private final static long Interval = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pamjaLojes = new GameView(this);
        setContentView(pamjaLojes);

        Timer timer =  new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        pamjaLojes.invalidate();
                    }
                });
            }
        },0,Interval);
    }
}

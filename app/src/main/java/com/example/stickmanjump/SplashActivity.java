package com.example.stickmanjump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity {
    Button Play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Pe lidhum qat buttonin Play qe e kemi te activity qe kur ta klikojm permes intentav me dal te display i lojes (qe se kemi kriju hala niher, pe boj niher mainActivity se nashta qaty e implementoj gameViewin)

        Play = (Button) findViewById(R.id.playButton);

        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playGame = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(playGame);
            }
        });


    }

}
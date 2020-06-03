package com.example.stickmanjump;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
 Button Play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Play = (Button) findViewById(R.id.playButton);

        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(play);
            }
        });
    }
}

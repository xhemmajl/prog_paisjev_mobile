package com.example.stickmanjump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GameOverActivity extends AppCompatActivity {
        private Button StartGameAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        TextView scoreLabel =  (TextView) findViewById(R.id.scoreLabel);
        TextView highScoreLabel = (TextView) findViewById(R.id.highScoreLabel);
         StartGameAgain = (Button) findViewById(R.id.play_again_btn);

    }
}

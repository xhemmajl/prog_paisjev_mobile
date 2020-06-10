package com.example.stickmanjump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {
        private Button StartGameAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        TextView scoreLabel =  (TextView) findViewById(R.id.scoreLabel);
        TextView highScoreLabel = (TextView) findViewById(R.id.highScoreLabel);
         StartGameAgain = (Button) findViewById(R.id.play_again_btn);
        //prej qeti line dej 41 ka tbaj me ta qit highscoren ... :)
        int score = getIntent().getIntExtra("SCORE",0);
        scoreLabel.setText("Score :"+score);
        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE",0);

        if(score>highScore){
            highScoreLabel.setText("High Score :"+score);

            //Save
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE",score);
            editor.commit();
        }
        else {
            highScoreLabel.setText("High Score :"+highScore);
        }
            StartGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(GameOverActivity.this,MainActivity.class);
                startActivity(mainIntent);


            }
        });

    }
}

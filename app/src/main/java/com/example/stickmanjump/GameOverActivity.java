package com.example.stickmanjump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
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
        //Ktu e kemi mundsu qe permes intentit , variabla score ne kete klas , me marr vleren e variables score ne klasen GameView, dhe pastaj me vendos ne ekran dhe me krahasu me highscoren.
        int score = getIntent().getIntExtra("SCORE",0);
        scoreLabel.setText("Score :"+score);
            //SharedPreferences eshte nje lloj databaze , nket rast ne po e ruajm highscoren nsharedPreferences
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
                Intent playAgain = new Intent(GameOverActivity.this,GameOpen.class);
                startActivity(playAgain);


            }
        });

    }
}

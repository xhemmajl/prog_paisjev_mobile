package com.example.stickmanjump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
       //pe deklaroj qetu prej qasaj gameview qe e banum , per me ba launch tash mainactivity
    private GameView pamjaLojes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //qetu e bona ni obj prej klases gameview po ja la niher emrin pamjaLojes.
        pamjaLojes = new GameView(this);
        setContentView(pamjaLojes);
    }
}

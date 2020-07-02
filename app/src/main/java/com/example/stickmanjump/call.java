package com.example.stickmanjump;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class call extends AppCompatActivity {

    ImageButton call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);


        call = findViewById(R.id.btncall);


    }

    public void callEvent(View v) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:049136072"));
        //qekjo nevojitet me kqyr se a e ka te lejum permisionin per me ba thirrje enabled perdoruesi!
        callIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);


        startActivity(callIntent);


    }}

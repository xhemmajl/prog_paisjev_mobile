package com.example.flyingfishgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class call_us extends AppCompatActivity {
    private static final int CALL_PERMISION_CODE = 100;


    ImageButton call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_us);


        call = findViewById(R.id.btncall);


    }

    public void callEvent(View v) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:049136072"));
        //qekjo nevojitet me kqyr se a e ka te lejum permisionin per me ba thirrje enabled perdoruesi!
        callIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        if (ActivityCompat.checkSelfPermission(call_us.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(call_us.this,new String[]{Manifest.permission.CALL_PHONE},CALL_PERMISION_CODE);

            return;
        }

        startActivity(callIntent);


    }
}

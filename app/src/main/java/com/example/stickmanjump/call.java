package com.example.stickmanjump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class call extends AppCompatActivity {

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


    }}

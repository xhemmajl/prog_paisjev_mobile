package com.example.stickmanjump;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    EditText Email;
    EditText Password;
    Button Login;
    TextView Registration;
    DatabaseHelper db;
    ConstraintLayout constrainLayout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.loginbtn);
        db = new DatabaseHelper(this);
        constrainLayout2 = findViewById(R.id.constrainLayout2);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email, password);
                if (Chkemailpass == true) {
                    Intent logInt = new Intent(LoginActivity.this, SplashActivity.class);
                    startActivity(logInt);
                }


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

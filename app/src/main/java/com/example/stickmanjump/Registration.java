package com.example.stickmanjump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Registration extends AppCompatActivity {
    EditText Password;
    EditText confirm_password;
    EditText Email;
    Button SignUp;
    TextView SignIn;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        
        db = new DatabaseHelper(this);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        confirm_password = (EditText) findViewById(R.id.confirmpassword);
        SignUp = (Button) findViewById(R.id.signupbtn);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmPassword = confirm_password.getText().toString();
                
                //nese i le te zbrasta ateher let del posht aty widget qe  i ke lan zbrast
                if(email.equals("") || password.equals("") || confirmPassword.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty?",Toast.LENGTH_SHORT).show();
                }
                //ateher nese dy paswordat perputhen ateher kqyre qajo email a ekziston ndatabaz, nese ekziston fute ndatabaz nese jo error
                else{
                    //nese passwordat perputhen
                    if(password.equals(confirmPassword)) {
                        //cheke a ekziston qaj email
                        Boolean chkemail = db.chkemail(email);
                        //nese qaj email nuk ekzsiton
    }
}

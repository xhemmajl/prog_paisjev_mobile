package com.example.stickmanjump;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;


public class First extends Fragment {

    EditText Email;
    EditText Password;
    Button Login;
    TextView Registration;
    DatabaseHelper db;
    ConstraintLayout constrainLayout2;

    public First() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_login, container, false);
        Email = (EditText) view.findViewById(R.id.email);
        Password = (EditText) view.findViewById(R.id.password);
        Login = (Button) view.findViewById(R.id.loginbtn);
        db = new DatabaseHelper(getContext());
        constrainLayout2 = view.findViewById(R.id.constrainLayout2);
        
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                //ni bolean per me check emailin edhe passwordin nga databaza
                Boolean Chkemailpass = db.emailpassword(email,password);
                //nese qeky boolean del true dmth  ekziston ateher hin ne loj meniher permes intentit
                if(Chkemailpass==true){
                    Intent logInt = new Intent(getActivity(),SplashActivity.class);
                    startActivity(logInt);
                }
                //perndryshe qite ni mesazh qe nuk jan mire
                else{
                    Snackbar.make(constrainLayout2,"Wrong Email or Password",Snackbar.LENGTH_LONG)
                            .setAction("Close", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })
                            .setActionTextColor(getResources().getColor(R.color.colorAccent)).show();
                }

            }
        });

        return view;
    }
}

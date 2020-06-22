package com.example.stickmanjump;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Second extends Fragment {
    EditText Password;
    EditText confirm_password;
    EditText Email;
    Button SignUp;
    DatabaseHelper db;


    public Second() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view2 =  inflater.inflate(R.layout.activity_registration, container, false);
        db = new DatabaseHelper(getContext());
        Email =  view2.findViewById(R.id.email);
        Password =  view2.findViewById(R.id.password);
        confirm_password =  view2.findViewById(R.id.confirmpassword);
        SignUp =  view2.findViewById(R.id.signupbtn);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmPassword = confirm_password.getText().toString();
                //nese i le te zbrasta ateher let del posht aty widget qe  i ke lan zbrast
                if(email.equals("") || password.equals("") || confirmPassword.equals("")){
                    Toast.makeText(getContext(),"Fields are empty?",Toast.LENGTH_SHORT).show();
                }
                //ateher nese dy paswordat perputhen ateher kqyre qajo email a ekziston ndatabaz, nese ekziston fute ndatabaz nese jo errori sa kryt
                else{
                    //nese passwordat perputhen
                    if(password.equals(confirmPassword)) {
                        //cheke a ekziston qaj email
                        Boolean chkemail = db.chkemail(email);
                        //nese qaj email nuk ekzsiton
                        if(chkemail==true){
                            //ateher provoje insertin ndatabaz
                            Boolean insert =  db.insert(email,password);
                            //nese inserti del true ateher je regjistru
                            if(insert==true) {
                                Toast.makeText(getContext(),"Registered Successfully.Back to Login",Toast.LENGTH_SHORT).show();}
                            //perndryshe nese emaili ekziston, error!
                            }
                        else{
                            Toast.makeText(getContext(),"This email address exist!!",Toast.LENGTH_SHORT).show();



                        }
                        //nese nuk perputhen pasat
                    }else
                        Toast.makeText(getContext(),"Password do not match!",Toast.LENGTH_SHORT).show();

                }


            }
        });

        return view2;
    }
}

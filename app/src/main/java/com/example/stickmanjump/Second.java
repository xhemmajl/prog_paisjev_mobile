package com.example.stickmanjump;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        View view2 =  inflater.inflate(R.layout.fragment_second, container, false);
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

        return view2;
    }
}

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

        return view2;
    }
}

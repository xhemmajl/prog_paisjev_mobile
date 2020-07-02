package com.example.stickmanjump;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.net.Uri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class Third extends Fragment {

    public Third() {
        // Required empty public constructor
    }
    public void clicked(String url){
        Intent openurl = new Intent(Intent.ACTION_VIEW);
        openurl.setData(Uri.parse(url));
        startActivity(openurl);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view3 =  inflater.inflate(R.layout.fragment_third, container, false);

        view3.findViewById(R.id.open_fb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked("https://www.facebook.com/Stickman-Jump-106282594483777");
            }
        });

        view3.findViewById(R.id.open_insta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked("https://instagram.com/ourpage");
            }
        });

        view3.findViewById(R.id.open_yt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked("https://youtube.com/ourpage");
            }
        });


        return view3;
    }

}



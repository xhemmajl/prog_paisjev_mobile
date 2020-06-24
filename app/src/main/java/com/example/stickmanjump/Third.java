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



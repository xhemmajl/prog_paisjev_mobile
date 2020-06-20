package com.example.flyingfishgame;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int tabsNumber;
    
    public PagerAdapter(@NonNull FragmentManager fm, int behavior,int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

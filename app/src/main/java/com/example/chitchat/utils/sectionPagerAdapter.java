package com.example.chitchat.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * class that stores fragments for tabs
 */
public class sectionPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "sectionPagerAdapter";

    private final List<Fragment> mfragmentList = new ArrayList<>();


    public sectionPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }

    public void addFragment(Fragment fragment){
        mfragmentList.add(fragment);
    }

}

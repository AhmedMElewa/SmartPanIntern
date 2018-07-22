package com.s1lrr.s1_login_register_retro.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.s1lrr.s1_login_register_retro.Fragments.Home;
import com.s1lrr.s1_login_register_retro.Fragments.Map;

/**
 * Created by Mada on 6/30/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Home tab1 = new Home();
                return tab1;
            case 1:
                Map tab2 = new Map();
                return tab2;
            default:
                Home tab = new Home();
                return tab;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
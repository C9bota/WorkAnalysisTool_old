package com.example.mdd.wa_uiprototype;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i){
            case 0:
                fragment = new InputFragment();
                break;
            default:
                fragment = new OutputFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

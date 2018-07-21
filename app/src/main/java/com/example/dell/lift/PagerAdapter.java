package com.example.dell.lift;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Dell on 07-Aug-17.
 */


//for the contacts activity
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
                AddAContactFragment tab1 = new AddAContactFragment();
                return tab1;
            case 1:
                AddAPartnerFragment tab2 = new AddAPartnerFragment();
                return tab2;
            case 2:
                AddADoctorFragment tab3 = new AddADoctorFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
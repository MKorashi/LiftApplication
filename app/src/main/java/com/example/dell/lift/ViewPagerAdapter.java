package com.example.dell.lift;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Dell on 09-Aug-17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
   public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
    }
 @Override
    public Fragment getItem(int position) {
    switch (position) {
            case 0:
                    ProfileTrackerFragment tab1 = new ProfileTrackerFragment();
                return tab1;
            case 1:
                    ProfileInfoFragment tab2 = new ProfileInfoFragment();
                return tab2;
            case 2:
                    ViewContactsFragment tab3 = new ViewContactsFragment();
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
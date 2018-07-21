package com.example.dell.lift;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_profile,container,false);
        Toolbar tb = (Toolbar) rootView.findViewById(R.id.toolbar);

       /* CircularImageView circularImageView = (CircularImageView)rootView.findViewById(R.id.circularImageView);
// Set Border
        circularImageView.setBorderColor(getResources().getColor(R.color.blue));
        circularImageView.setBorderWidth(10);
// Add Shadow with default param
        circularImageView.addShadow();
// or with custom param
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.RED);*/



        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.android_icon);
        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 100);

        ImageView circularImageView = (ImageView)rootView.findViewById(R.id.circleView);
        circularImageView.setImageBitmap(circularBitmap);

        ((AppCompatActivity) getActivity()).setSupportActionBar(tb);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);


        tabLayout.addTab(tabLayout.newTab().setText("OVERVIEW"));
        tabLayout.addTab(tabLayout.newTab().setText("INFO"));
        tabLayout.addTab(tabLayout.newTab().setText("CONTACTS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.pager_profile);
        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
            public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());






            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
           }
           @Override
            public void onTabReselected(TabLayout.Tab tab) {
          }
        });



        return rootView;
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       // inflater.inflate(R.menu.action_bar_options, menu);
        //return true;*/

        Toolbar tb = (Toolbar) this.getActivity().findViewById(R.id.toolbar);
        tb.inflateMenu(R.menu.action_bar_options);

        tb.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return onOptionsItemSelected(item);
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.d("transaction done2","");

        // Handle item selection
        if(item.getItemId() == R.id.actionbar_menu){
            SettingsFragment settingsFragment = new SettingsFragment();
            FragmentChangeListener fc=(FragmentChangeListener) getActivity();
            fc.replaceFragment(settingsFragment);

            /*FragmentTransaction transaction = this.getActivity().getSupportFragmentManager().
                    beginTransaction();
            SettingsFragment settingsFragment = new SettingsFragment();
            transaction.replace(R.id.frame_layout, settingsFragment);*/
Log.d("transaction done","");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    private void setupViewPager(ViewPager viewPager) {

        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new ProfileTrackerFragment(), "OVERVIEW");
        adapter.addFragment(new ProfileInfoFragment(), "INFO");
        adapter.addFragment(new ViewContactsFragment(), "CONTACTS");
        viewPager.setAdapter(adapter);

    }



}



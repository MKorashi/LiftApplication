package com.example.dell.lift;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity implements FragmentChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        FragmentTransaction transaction = getSupportFragmentManager().
                                beginTransaction();

                        switch (item.getItemId()) {
                            case R.id.action_item1:
                              MoodFragment moodFragment = new MoodFragment();
                             //   MoodLogFragment moodLogFragment = new MoodLogFragment();
                                transaction.replace(R.id.frame_layout, moodFragment);

                                break;
                            case R.id.action_item2:
                                MedsFragment medsFragment = new MedsFragment();
                                transaction.replace(R.id.frame_layout, medsFragment);

                                break;
                            case R.id.action_item3:
                               AlcoholFragment alcoholFragment = new AlcoholFragment();
                                transaction.replace(R.id.frame_layout, alcoholFragment);

                                break;
                            case R.id.action_item4:
                                ProfileFragment profileFragment = new ProfileFragment();
                                transaction.replace(R.id.frame_layout, profileFragment);

                                break;
                        }

                        transaction.commit();
                        return true;
                    }
                });




    }

    @Override
    public void replaceFragment(android.support.v4.app.Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();
    }

    // @Override
   /* public void replaceFragment(android.support.v4.app.Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();
    }*/

   /* @Override
    protected void onResume() {
        super.onResume();

        if(!Utility.isUserLoggedIn(this)){
            startActivity(new Intent(this, LoginActivity.class));
        }
    }*/
}

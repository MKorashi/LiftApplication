package com.example.dell.lift;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dell.lift.Entities.AlcoholDrink;
import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;

public class AlcoholFragment extends Fragment {
    @Nullable

    private DonutProgress donutProgress;
    private boolean progressChanged = true;
    private int currentBACLevel = 0 + 10;

    private ArrayList<AlcoholDrink> drinksArray = new ArrayList<AlcoholDrink>();

    RecyclerView MyRecyclerView;
    DrinksAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_alcohol,container,false);

        initializeList();

        myAdapter = new DrinksAdapter(drinksArray);

        donutProgress = (DonutProgress) rootView.findViewById(R.id.donut_progress);

      /*  if(progressChanged){
            @SuppressLint("ObjectAnimatorBinding")
            ObjectAnimator anim = ObjectAnimator.ofInt(donutProgress, "progress", 10);
            anim.setInterpolator(new DecelerateInterpolator());
            anim.setDuration(500);
            anim.start();
            progressChanged = false;
        }
        else {
            AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this.getContext(), R.animator.progress_anim);
            set.setInterpolator(new DecelerateInterpolator());
            set.setTarget(donutProgress);
            set.start();
        }*/

        drinksArray.add(new AlcoholDrink("Beer"));
        drinksArray.add(new AlcoholDrink("Shot of Vodka"));
        drinksArray.add(new AlcoholDrink("Tequila Sunrise"));

        donutProgress.setDonut_progress(Integer.toString(currentBACLevel));
        Toast.makeText(this.getContext(), "Blood Alcohol Count Estimate Changed", Toast.LENGTH_LONG).show();


        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        MyRecyclerView = (RecyclerView) rootView.findViewById(R.id.drinks_recycler_view);
        MyRecyclerView.setHasFixedSize(true);
        MyRecyclerView.setLayoutManager(MyLayoutManager);

        MyRecyclerView.setAdapter(myAdapter);
        registerForContextMenu(MyRecyclerView);

       /* ArrayAdapter adapter = new ArrayAdapter<String>(this.getContext(), R.layout.drinks_had_today_list,drinksArray);
        ListView listView = (ListView) rootView.findViewById(R.id.Drinks_listview);
        listView.setAdapter(adapter);*/

        FloatingActionButton myFab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //change to new med screen
               drinkFragment newdrinkFragment = new drinkFragment();
                Log.d("My Message", "Hi");
                FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                fc.replaceFragment(newdrinkFragment);
            }
        });


        return rootView;
    }


    public void initializeList() {
        /*drinksArray.clear();
        int medicationsSize = Medications.length;
        for(int i =0;i<medicationsSize;i++){
            Medication Med = new Medication(Medications[i]);
            drinksArray.add(Med);
        }*/

    }
}
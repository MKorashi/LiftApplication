package com.example.dell.lift;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.lift.Entities.AlcoholDrink;

import java.util.ArrayList;

/**
 * Created by Dell on 30-Jul-17.
 */

public class DrinksAdapter  extends RecyclerView.Adapter<DrinksViewHolder> {
    private ArrayList<AlcoholDrink> list;

    public DrinksAdapter(ArrayList<AlcoholDrink> Data) {
        list = Data;
    }

    @Override
    public DrinksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drinks_had_today_list
                        , parent, false);
        DrinksViewHolder holder = new DrinksViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final DrinksViewHolder holder, int position) {

        holder.titleTextView.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

package com.example.dell.lift;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.lift.Entities.Medication;

import java.util.ArrayList;

public class MedicationListAdapter extends RecyclerView.Adapter<MedsViewHolder> {
    private ArrayList<Medication> list;

    public MedicationListAdapter(ArrayList<Medication> Data) {
        list = Data;
    }

    @Override
    public MedsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medication_card
                        , parent, false);
        MedsViewHolder holder = new MedsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MedsViewHolder holder, int position) {

       holder.titleTextView.setText(list.get(position).getMedName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }




}
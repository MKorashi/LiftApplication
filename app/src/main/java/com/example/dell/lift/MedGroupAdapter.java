package com.example.dell.lift;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.lift.Entities.Medication_Group;

import java.util.ArrayList;

public class MedGroupAdapter extends RecyclerView.Adapter<MedGroupViewHolder> {
    private ArrayList<Medication_Group> list;

    public MedGroupAdapter(ArrayList<Medication_Group> Data) {
        list = Data;
    }

    @Override
    public MedGroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medgroup_card
                        , parent, false);
        MedGroupViewHolder holder = new MedGroupViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MedGroupViewHolder holder, int position) {

        holder.titleTextView.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }




}
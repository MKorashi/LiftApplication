package com.example.dell.lift;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.lift.Entities.Measurement;

import java.util.ArrayList;

/**
 * Created by Dell on 27-Jul-17.
 */

public class MeasurementListAdapter extends RecyclerView.Adapter<MeasurementsViewHolder> {
    private ArrayList<Measurement> list;

    public MeasurementListAdapter(ArrayList<Measurement> Data) {
        list = Data;
    }

    @Override
    public MeasurementsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.measurement_card
                        , parent, false);
        MeasurementsViewHolder holder = new MeasurementsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MeasurementsViewHolder holder, int position) {

        holder.titleTextView.setText(list.get(position).getMeasurement_name());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}



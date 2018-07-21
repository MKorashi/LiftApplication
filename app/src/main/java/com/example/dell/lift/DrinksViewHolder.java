package com.example.dell.lift;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Dell on 30-Jul-17.
 */

public class DrinksViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
    public final View mView;
    public final TextView titleTextView;
    public final TextView dateTextView;
    public String mItem;

    public DrinksViewHolder(View view) {
        super(view);
        mView = view;
        titleTextView = (TextView) view.findViewById(R.id.drink_text);
        dateTextView = (TextView) view.findViewById(R.id.dateAndTimeForDrink);
        view.setOnCreateContextMenuListener(this);
    }

    @Override
    public String toString() {
        return super.toString() + "'";
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Edit");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "Delete");

    }
}
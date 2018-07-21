package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Dell on 14-Aug-17.
 */

@Entity(tableName = "alcohol_presets", foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "email", childColumns = "email", onDelete = CASCADE, onUpdate = CASCADE),
        @ForeignKey(entity = AlcoholDrink.class, parentColumns = "drink_id", childColumns = "drink_id", onDelete = CASCADE, onUpdate = CASCADE)}, primaryKeys = {"email", "drink_id"})
public class Alcohol_Presets {

   // private ArrayList<AlcoholDrink> presets = new ArrayList<AlcoholDrink>();

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "drink_id")
    private int drink_id;

    public Alcohol_Presets(){
        //empty default constructor
    }

   /* public ArrayList<AlcoholDrink> getList(){
        return presets;
    }

    public int getListSize(){
        return presets.size();
    }

    public void addtoList(AlcoholDrink x){
        this.presets.add(x);
    }

    public void deleteFromList(AlcoholDrink x){
        this.presets.remove(x);
    }*/


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(int drink_id) {
        this.drink_id = drink_id;
    }
}

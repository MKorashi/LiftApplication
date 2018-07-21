package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Dell on 14-Aug-17.
 */
@Entity(tableName = "alcohol_drinks_had",
foreignKeys = {@ForeignKey(entity = AlcoholDrink.class, childColumns = "drink_id", parentColumns = "drink_id", onDelete = CASCADE, onUpdate = CASCADE),
        @ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email", onDelete = CASCADE, onUpdate = CASCADE)}, primaryKeys = {"dateTime","email","drink_id"})
public class Alcohol_Drinks_Had {

//    ArrayList<AlcoholDrink> alcohol_Drinks_Had = new ArrayList<AlcoholDrink>();

    @ColumnInfo(name = "dateTime")
    private String dateTime;

    @ColumnInfo(name = "drink_id")
    private int drink_id;

    @ColumnInfo(name = "email")
    private String email;



    public Alcohol_Drinks_Had(){
        //empty default constructor .. don't think it will ever be used!
    }


   /* public ArrayList<AlcoholDrink> getList(){
        return alcohol_Drinks_Had;
    }

    public int getListSize(){
        return alcohol_Drinks_Had.size();
    }

    public void addtoList(AlcoholDrink x){
        this.alcohol_Drinks_Had.add(x);
    }

    public void deleteFromList(AlcoholDrink x){
        this.alcohol_Drinks_Had.remove(x);
    }*/

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String date) {
        this.dateTime = date;
    }

    public int getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(int drink_id) {
        this.drink_id = drink_id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

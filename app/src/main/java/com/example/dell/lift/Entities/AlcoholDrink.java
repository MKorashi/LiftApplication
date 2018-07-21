package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.dell.lift.Converters.DrinkUnitConverter;
import com.example.dell.lift.DrinkUnit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Dell on 30-Jul-17.
 */

@Entity(tableName = "alcohol_drinks", foreignKeys = {@ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email", onDelete = CASCADE, onUpdate = CASCADE)}
 , indices = {@Index(value = {"drink_id", "email"}, unique = true)})
public class AlcoholDrink {

    @PrimaryKey(autoGenerate = true)
    private int drink_id;
    //userid FK

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "volume")
    private int volume;

    @TypeConverters(DrinkUnitConverter.class)
    @ColumnInfo(name = "drinkUnit")
    private DrinkUnit drinkUnit;

    @ColumnInfo(name = "alcohol_content")
    private int alcohol_content;

    @ColumnInfo(name = "created_at")
    private String created_at;


    public AlcoholDrink(){

    }

    @Ignore
    public AlcoholDrink(String name){

        this.name = name;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currentDate = new Date();
        // System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        this.created_at = dateFormat.format(currentDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at(){
        return this.created_at;
    }

    public int getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(int drink_id) {
        this.drink_id = drink_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public DrinkUnit getDrinkUnit() {
        return drinkUnit;
    }

    public void setDrinkUnit(DrinkUnit drinkUnit) {
        this.drinkUnit = drinkUnit;
    }

    public int getAlcohol_content() {
        return alcohol_content;
    }

    public void setAlcohol_content(int alcohol_content) {
        this.alcohol_content = alcohol_content;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}

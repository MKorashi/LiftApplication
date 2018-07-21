package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Dell on 27-Jul-17.
 */

@Entity(tableName = "measurements", primaryKeys = {"email","measurement_name"}, foreignKeys = {@ForeignKey(entity = User.class,
parentColumns = "email", childColumns = "email", onDelete = CASCADE, onUpdate = CASCADE)}, indices = {@Index(value = {"measurement_name"}, unique = true)} )

public class Measurement {

    @ColumnInfo(name = "measurement_name")
   private String measurement_name;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "unit")
    private String unit;

    @ColumnInfo(name = "created_at")
    private String created_at;

    @ColumnInfo(name = "range_min")
    private int Range_min;

    @ColumnInfo(name = "range_max")
    private int Range_max;

    public Measurement(){

    }

    public Measurement(String name){
        this.measurement_name = name;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currentDate = new Date();
        // System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        this.created_at = dateFormat.format(currentDate);

        switch(name){
            //assign range_min, and range_max values
        }


    }

    public String getMeasurement_name() {
        return measurement_name;
    }

    public void setMeasurement_name(String name) {
        this.measurement_name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getRange_min() {
        return Range_min;
    }

    public void setRange_min(int range_min) {
        Range_min = range_min;
    }

    public int getRange_max() {
        return Range_max;
    }

    public void setRange_max(int range_max) {
        Range_max = range_max;
    }
}

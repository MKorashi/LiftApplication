package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dell on 07-Aug-17.
 */

@Entity(tableName = "measurements_data", foreignKeys ={@ForeignKey(entity = Measurement.class, parentColumns = "measurement_name", childColumns = "measurement_name"),
        @ForeignKey(entity = User.class, parentColumns = "email", childColumns = "email")},
        primaryKeys = {"measurement_name", "date", "email"})

public class Measurements_Data {

    @ColumnInfo(name = "measurement_name")
    private String measurement_name;

    @ColumnInfo(name = "email")
    private String email; //FK

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "value")
    private int value;

    @ColumnInfo(name = "created_at")
    private String created_at;


    public  Measurements_Data(){

    }


    @Ignore
    private Measurements_Data(String name, int value){
        this.measurement_name = name;
        this.value = value;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currentDate = new Date();
        // System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        this.created_at = dateFormat.format(currentDate);

    }

    public String getMeasurement_name() {
        return measurement_name;
    }

    public void setMeasurement_name(String measurement_name) {
        this.measurement_name = measurement_name;
    }

   public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}

package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

/**
 * Created by Dell on 20-Aug-17.
 */

@Entity(tableName = "sleep_logs", primaryKeys = {"email","date"},
foreignKeys = {@ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email")})

public class Sleep_Log {

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "numberOfHours")
    private int numberOfHours;

    public Sleep_Log(){

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

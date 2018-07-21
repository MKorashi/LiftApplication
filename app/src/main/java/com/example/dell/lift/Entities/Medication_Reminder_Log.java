package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

/**
 * Created by Dell on 20-Aug-17.
 */

@Entity(tableName = "medication_reminder_log", primaryKeys = {"reminder_id", "email", "date"},
        foreignKeys = {@ForeignKey(entity = Medication_Reminder.class, childColumns = "reminder_id", parentColumns = "reminder_id"),
        @ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email")})

public class Medication_Reminder_Log {


    @ColumnInfo(name = "reminder_id")
    private int reminder_id;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "confirmed")
    private boolean confirmed;

    @ColumnInfo(name = "date")
    private String date;


    public Medication_Reminder_Log(){

    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getReminder_id() {
        return reminder_id;
    }

    public void setReminder_id(int reminder_id) {
        this.reminder_id = reminder_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String user_id) {
        this.email = email;
    }
}

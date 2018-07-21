package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Dell on 20-Aug-17.
 */

@Entity(tableName = "measurement_reminder_days", foreignKeys = {@ForeignKey(entity = Measurements_Reminder.class, childColumns = "reminder_id", parentColumns = "reminder_id", onDelete = CASCADE, onUpdate = CASCADE), @ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email", onDelete = CASCADE, onUpdate = CASCADE)},
        primaryKeys = {"day", "reminder_id", "email"})
public class Measurement_Reminder_Days {

    //times during the day for the reminder

    @ColumnInfo(name = "day")
    private String day;

    @ColumnInfo(name = "reminder_id")
    private int reminder_id;

    @ColumnInfo(name = "email")
    private String email;

    public Measurement_Reminder_Days(){

    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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

    public void setEmail(String email) {
        this.email = email;
    }
}

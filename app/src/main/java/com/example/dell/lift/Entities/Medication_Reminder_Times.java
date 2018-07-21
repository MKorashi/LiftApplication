package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Dell on 20-Aug-17.
 */
@Entity(tableName = "medication_reminder_times", foreignKeys = {@ForeignKey(entity = Medication_Reminder.class, childColumns = "reminder_id", parentColumns = "reminder_id"), @ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email", onDelete = CASCADE, onUpdate = CASCADE)},
        primaryKeys = {"time", "reminder_id", "email"})
public class Medication_Reminder_Times {
    //times during the day for the reminder

    @ColumnInfo(name = "time")
    private String time; //PK

    @ColumnInfo(name = "reminder_id")
    private int reminder_id;

    @ColumnInfo(name = "email")
    private String email;

    public Medication_Reminder_Times(){

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

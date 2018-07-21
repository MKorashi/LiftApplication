package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

/**
 * Created by Dell on 20-Aug-17.
 */


@Entity(tableName = "medication_group_reminder_days", foreignKeys = {@ForeignKey(entity = Medication_Group_Reminder.class, childColumns = "reminder_id", parentColumns = "reminder_id"), @ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email")},
        primaryKeys = {"day", "reminder_id", "email"})

public class Medication_Group_Reminder_Days {

    //times during the day for the reminder

    @ColumnInfo(name = "day")
    private String day; //PK

    @ColumnInfo(name = "reminder_id")
    private int reminder_id;

    @ColumnInfo(name = "email")
    private String email;

    //FK, PK reminder_id
    //FK, PK user_id

    public Medication_Group_Reminder_Days(){

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

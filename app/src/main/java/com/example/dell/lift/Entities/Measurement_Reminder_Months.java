package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

/**
 * Created by Dell on 20-Aug-17.
 */

@Entity(tableName = "measurement_reminder_months", primaryKeys = {"month", "reminder_id", "email"},
foreignKeys = {@ForeignKey(entity = Measurements_Reminder.class, parentColumns = "reminder_id", childColumns = "reminder_id"),
        @ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email")})

public class Measurement_Reminder_Months {

    //days during the month for the reminder

    @ColumnInfo(name = "month")
    private String month; //PK

    @ColumnInfo(name = "reminder_id")
    private int reminder_id;

    @ColumnInfo(name = "email")
    private String email;

    public Measurement_Reminder_Months(){


    }

    public String getMonth() {
        return month;
    }

    public void setTime(String month) {
        this.month = month;
    }

    public void setMonth(String month) {
        this.month = month;
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

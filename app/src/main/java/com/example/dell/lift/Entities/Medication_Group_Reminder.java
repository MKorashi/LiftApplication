package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.TypeConverters;

import com.example.dell.lift.Converters.IntakeFrequencyConverter;
import com.example.dell.lift.Converters.ReminderModeConverter;
import com.example.dell.lift.IntakeFrequency;
import com.example.dell.lift.ReminderMode;

/**
 * Created by Dell on 20-Aug-17.
 */
@Entity(tableName = "medication_group_reminders", foreignKeys = {@ForeignKey(entity = Medication_Group.class, parentColumns = "group_id", childColumns = "group_id"),
        @ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email")}, primaryKeys = {"email","reminder_id"}, indices = {@Index(value = {"reminder_id"}, unique = true)})

public class Medication_Group_Reminder {

    @ColumnInfo(name = "reminder_id")
    private int reminder_id;

    @ColumnInfo(name = "reminderMode")
    @TypeConverters(ReminderModeConverter.class)
    private ReminderMode reminderMode;

    @ColumnInfo(name = "intakeFrequency")
    @TypeConverters(IntakeFrequencyConverter.class)
    private IntakeFrequency intakeFrequency;

    @ColumnInfo(name = "group_id")
    private int group_id;

    @ColumnInfo(name = "email")
    private String email;
    //FK group_id;
    //FK user_id PK

    public Medication_Group_Reminder(){

    }

    public int getReminder_id() {
        return reminder_id;
    }

    public void setReminder_id(int reminder_id) {
        this.reminder_id = reminder_id;
    }

    public ReminderMode getReminderMode() {
        return reminderMode;
    }

    public void setReminderMode(ReminderMode reminderMode) {
        this.reminderMode = reminderMode;
    }

    public IntakeFrequency getIntakeFrequency() {
        return intakeFrequency;
    }

    public void setIntakeFrequency(IntakeFrequency intakeFrequency) {
        this.intakeFrequency = intakeFrequency;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

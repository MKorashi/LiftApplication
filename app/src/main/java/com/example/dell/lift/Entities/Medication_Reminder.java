package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.dell.lift.Converters.IntakeFrequencyConverter;
import com.example.dell.lift.Converters.ReminderModeConverter;
import com.example.dell.lift.IntakeFrequency;
import com.example.dell.lift.ReminderMode;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Dell on 20-Aug-17.
 */

@Entity(tableName = "medication_reminders", foreignKeys = {@ForeignKey(entity = Medication.class, parentColumns = "med_id", childColumns = "med_id"),
        @ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email", onDelete = CASCADE, onUpdate = CASCADE)}, primaryKeys = {"email", "reminder_id"},
        indices = {@Index(value = {"reminder_id"}, unique = true)})

public class Medication_Reminder {

    @ColumnInfo(name = "reminder_id")
    private int reminder_id; //PK

    @ColumnInfo(name = "dosagePerReminder")
    private int dosagePerReminder;

    @ColumnInfo(name = "intakeFrequency")
    @TypeConverters(IntakeFrequencyConverter.class)
    private IntakeFrequency intakeFrequency;

    @ColumnInfo(name = "reminderMode")
    @TypeConverters(ReminderModeConverter.class)
    private ReminderMode reminderMode;

    @ColumnInfo(name = "med_id")
    private int med_id;

    @ColumnInfo(name = "email")
    private String email;
    //foreign key med_id
    //foreign key user_id

    public Medication_Reminder(){

    }

    public int getReminder_id() {
        return reminder_id;
    }

    public void setReminder_id(int reminder_id) {
        this.reminder_id = reminder_id;
    }

    public int getDosagePerReminder() {
        return dosagePerReminder;
    }

    public void setDosagePerReminder(int dosagePerReminder) {
        this.dosagePerReminder = dosagePerReminder;
    }

    public IntakeFrequency getIntakeFrequency() {
        return intakeFrequency;
    }

    public void setIntakeFrequency(IntakeFrequency intakeFrequency) {
        this.intakeFrequency = intakeFrequency;
    }

    public ReminderMode getReminderMode() {
        return reminderMode;
    }

    public void setReminderMode(ReminderMode reminderMode) {
        this.reminderMode = reminderMode;
    }

    public int getMed_id() {
        return med_id;
    }

    public void setMed_id(int med_id) {
        this.med_id = med_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.dell.lift.Converters.FrequencyConverter;
import com.example.dell.lift.Converters.ReminderModeConverter;
import com.example.dell.lift.Frequency;
import com.example.dell.lift.ReminderMode;

/**
 * Created by Dell on 20-Aug-17.
 */

@Entity(tableName = "measurement_reminders",
foreignKeys = {@ForeignKey(entity = Measurement.class, childColumns = "measurement_name", parentColumns = "measurement_name"),
@ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email")}, indices = {@Index(value = {"reminder_id", "email"}, unique = true)})

public class Measurements_Reminder {

    @PrimaryKey(autoGenerate = true)
    private int reminder_id;

    @ColumnInfo(name = "reminderMode")
    @TypeConverters(ReminderModeConverter.class)
    private ReminderMode reminderMode;

    @ColumnInfo(name = "measurement_name")
    private String measurement_name; //FK

    @ColumnInfo(name = "frequency")
    @TypeConverters(FrequencyConverter.class)
    private Frequency frequency;

    @ColumnInfo(name = "email")
    private String email;

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

    public String getMeasurement_name() {
        return measurement_name;
    }

    public void setMeasurement_name(String measurement_name) {
        this.measurement_name = measurement_name;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

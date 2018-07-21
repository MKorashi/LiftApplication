package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.dell.lift.Converters.DurationConverter;
import com.example.dell.lift.Converters.IntakeAdviceConverter;
import com.example.dell.lift.Duration;
import com.example.dell.lift.IntakeAdvice;

/**
 * Created by Dell on 20-Aug-17.
 */

@Entity(tableName = "medication_details", primaryKeys = {"startDate", "med_id", "email"},
        foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "email", childColumns = "email"),
                @ForeignKey(entity = Medication.class, childColumns = "med_id", parentColumns = "med_id")})

public class Medication_Details {

    @ColumnInfo(name = "med_id")
    private int med_id;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "dosage")
    private int dosage;

    @ColumnInfo(name = "intakeAdvice")
    @TypeConverters(IntakeAdviceConverter.class)
    private IntakeAdvice intakeAdvice;

    @ColumnInfo(name = "customIntakeAdvice")
    private String customIntakeAdvice;

    @ColumnInfo(name = "plannedOrNot")
    private boolean plannedOrNot;

    @ColumnInfo(name = "startDate")
    private String startDate; //PK

    @ColumnInfo(name = "duration")
    @TypeConverters(DurationConverter.class)
    private Duration duration;

    @ColumnInfo(name = "endDate")
    private String endDate;

    public Medication_Details(){

    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public IntakeAdvice getIntakeAdvice() {
        return intakeAdvice;
    }

    public void setIntakeAdvice(IntakeAdvice intakeAdvice) {
        this.intakeAdvice = intakeAdvice;
    }

    public String getCustomIntakeAdvice() {
        return customIntakeAdvice;
    }

    public void setCustomIntakeAdvice(String customIntakeAdvice) {
        this.customIntakeAdvice = customIntakeAdvice;
    }

    public boolean isPlannedOrNot() {
        return plannedOrNot;
    }

    public void setPlannedOrNot(boolean plannedOrNot) {
        this.plannedOrNot = plannedOrNot;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

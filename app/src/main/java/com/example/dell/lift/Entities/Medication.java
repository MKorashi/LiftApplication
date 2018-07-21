package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.dell.lift.Converters.MedUnitConverter;
import com.example.dell.lift.Unit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dell on 17-Jul-17.
 */

@Entity(tableName = "medications", foreignKeys={@ForeignKey(entity = User.class, parentColumns = "email", childColumns = "email")} )

public class Medication {

    @PrimaryKey(autoGenerate = true)
    private int med_id;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "medName")
    private String medName;

    @ColumnInfo(name = "addedAt")
    private String addedAt; //auto generated in constructor

    @ColumnInfo(name = "unit")
    @TypeConverters(MedUnitConverter.class)
    private Unit unit;
    //private boolean plannedOrNot;
    //private int dosage;
    //private IntakeAdvice intakeAdvice;
    //private String customIntakeAdvice;
   // private Date startDate;
    //private Duration duration;
    //private Date endDate;
    //private int durationDays;
    //private IntakeFrequency intakeFrequency;
    //private int intake_numberOfDays;
    //private int intake_numberOfHours;
    //private String intake_whichDays;
    //private boolean Reminder;
    //private Date reminder_time;
    //private ReminderMode reminder_mode;
    //private int dosage_per_reminder;

    public Medication(){

    }

    public Medication(String name) {
        medName = name;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currentDate = new Date();
       // System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        this.addedAt = dateFormat.format(currentDate);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMed_id() {
        return med_id;
    }

    public void setMed_id(int med_id) {
        this.med_id = med_id;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

   /* public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public IntakeFrequency getIntakeFrequency() {
        return intakeFrequency;
    }

    public void setIntakeFrequency(IntakeFrequency intakeFrequency) {
        this.intakeFrequency = intakeFrequency;
    }

    public int getIntake_numberOfDays() {
        return intake_numberOfDays;
    }

    public void setIntake_numberOfDays(int intake_numberOfDays) {
        this.intake_numberOfDays = intake_numberOfDays;
    }

    public int getIntake_numberOfHours() {
        return intake_numberOfHours;
    }

    public void setIntake_numberOfHours(int intake_numberOfHours) {
        this.intake_numberOfHours = intake_numberOfHours;
    }

    public String getIntake_whichDays() {
        return intake_whichDays;
    }

    public void setIntake_whichDays(String intake_whichDays) {
        this.intake_whichDays = intake_whichDays;
    }

    public boolean isReminder() {
        return Reminder;
    }

    public void setReminder(boolean reminder) {
        Reminder = reminder;
    }

    public Date getReminder_time() {
        return reminder_time;
    }

    public void setReminder_time(Date reminder_time) {
        this.reminder_time = reminder_time;
    }

    public ReminderMode getReminder_mode() {
        return reminder_mode;
    }

    public void setReminder_mode(ReminderMode reminder_mode) {
        this.reminder_mode = reminder_mode;
    }

    public int getDosage_per_reminder() {
        return dosage_per_reminder;
    }

    public void setDosage_per_reminder(int dosage_per_reminder) {
        this.dosage_per_reminder = dosage_per_reminder;
    }



    public boolean isPlannedOrNot() {
        return plannedOrNot;
    }

    public void setPlannedOrNot(boolean plannedOrNot) {
        this.plannedOrNot = plannedOrNot;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }*/
}
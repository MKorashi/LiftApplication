package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dell on 27-Jul-17.
 */

@Entity(tableName = "medication_groups", foreignKeys = {@ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email")})

public class Medication_Group {

    @ColumnInfo(name = "email")
    private String email; //FK

    @PrimaryKey(autoGenerate = true)
    private int group_id; //primary key

    @ColumnInfo(name = "created_at")
    private String created_at; //auto generated inside the constructor

    @ColumnInfo(name = "group_name")
    private String group_name;

    @ColumnInfo(name = "reminderYesOrNo")
    private boolean reminderYesOrNo;
    //private String reminder_frequency;
    //private String reminder_time;
    //private ReminderMode reminder_mode;
    //private ArrayList<Medication> group_meds;

    public Medication_Group(){

    }

    public Medication_Group(String name){

        this.group_name = name;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currentDate = new Date();
        // System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        this.created_at = dateFormat.format(currentDate);
        //this.group_meds = new ArrayList<>();
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    /*public String getReminder_time() {
        return reminder_time;
    }

    public void setReminder_time(String reminder_time) {
        this.reminder_time = reminder_time;
    }

    public ReminderMode getReminder_mode() {
        return reminder_mode;
    }

    public void setReminder_mode(ReminderMode reminder_mode) {
        this.reminder_mode = reminder_mode;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }*/

    public String getName() {
        return group_name;
    }

    public void setName(String name) {
        this.group_name = name;
    }

    public boolean isReminder() { return reminderYesOrNo; }

    public void setReminder(boolean reminder) { this.reminderYesOrNo = reminder;  }

   /* public ArrayList<Medication> getGroup_meds() { return group_meds; }

    public void setGroup_meds(ArrayList<Medication> group_meds) { this.group_meds = group_meds; }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isReminderYesOrNo() {
        return reminderYesOrNo;
    }

    public void setReminderYesOrNo(boolean reminderYesOrNo) {
        this.reminderYesOrNo = reminderYesOrNo;
    }
}

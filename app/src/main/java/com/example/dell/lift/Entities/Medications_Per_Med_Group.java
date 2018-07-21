package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Dell on 20-Aug-17.
 */

@Entity(tableName = "medications_per_med_group", primaryKeys = {"email", "group_id", "med_id"},
foreignKeys = {@ForeignKey(entity = Medication_Group.class, childColumns = "group_id", parentColumns = "group_id"), @ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email", onDelete = CASCADE, onUpdate = CASCADE),
        @ForeignKey(entity = Medication.class, childColumns = "med_id", parentColumns = "med_id")})

public class Medications_Per_Med_Group {

    @ColumnInfo(name = "group_id")
    private int group_id;

    @ColumnInfo(name = "med_id")
    private int med_id;

    @ColumnInfo(name = "email")
    private String email;

    public Medications_Per_Med_Group() {
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
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

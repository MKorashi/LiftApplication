package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

/**
 * Created by Dell on 20-Aug-17.
 */
@Entity(tableName = "medications_history", primaryKeys = {"email","dateTimeTaken","med_id" },
foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "email", childColumns = "email"),
@ForeignKey(entity = Medication.class, childColumns = "med_id", parentColumns = "med_id")})
public class Medications_History {

    @ColumnInfo(name = "med_id")
    private int med_id;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "dateTimeTaken")
    private String dateTimeTaken;

    @ColumnInfo(name = "dosage")
    private int dosage;

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

    public String getDateTimeTaken() {
        return dateTimeTaken;
    }

    public void setDateTimeTaken(String dateTimeTaken) {
        this.dateTimeTaken = dateTimeTaken;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }
}

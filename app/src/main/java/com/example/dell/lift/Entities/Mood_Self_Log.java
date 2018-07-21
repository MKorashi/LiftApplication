package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Dell on 20-Aug-17.
 */

@Entity(tableName = "mood_self_logs", primaryKeys = {"dateTime", "email"},
foreignKeys = {@ForeignKey(entity = User.class, childColumns = "email", parentColumns = "email", onDelete = CASCADE, onUpdate = CASCADE)})

public class Mood_Self_Log {


    @ColumnInfo(name = "dateTime")
    private String dateTime;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "negativeEffect")
    private int negativeEffect;

    @ColumnInfo(name = "positiveEffect")
    private int positiveEffect;

    @ColumnInfo(name = "pleasantness")
    private int pleasantness;

    @ColumnInfo(name = "engagement")
    private int engagement;


    public Mood_Self_Log() {

    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String date) {
        this.dateTime = date;
    }

    public int getNegativeEffect() {
        return negativeEffect;
    }

    public void setNegativeEffect(int negativeEffect) {
        this.negativeEffect = negativeEffect;
    }

    public int getPositiveEffect() {
        return positiveEffect;
    }

    public void setPositiveEffect(int positiveEffect) {
        this.positiveEffect = positiveEffect;
    }

    public int getPleasantness() {
        return pleasantness;
    }

    public void setPleasantness(int pleasantness) {
        this.pleasantness = pleasantness;
    }

    public int getEngagement() {
        return engagement;
    }

    public void setEngagement(int engagement) {
        this.engagement = engagement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

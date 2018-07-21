package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Dell on 20-Aug-17.
 */


@Entity(tableName = "auto_text_mood_log", primaryKeys = {"dateTime", "email"},
foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "email", childColumns = "email", onDelete = CASCADE, onUpdate = CASCADE)})
public class Auto_Text_Mood_Log {

    @ColumnInfo(name = "dateTime")
    private String dateTime;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "text")
    private String text;

    @ColumnInfo(name = "result")
    private String result;


    public Auto_Text_Mood_Log(){

    }

    public String getDate() {
        return dateTime;
    }

    public void setDate(String date) {
        this.dateTime = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

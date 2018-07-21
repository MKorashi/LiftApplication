package com.example.dell.lift.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.dell.lift.ReminderMode;

/**
 * Created by Dell on 23-Aug-17.
 */

public class ReminderModeConverter {

    @TypeConverter
    public String convertToString(ReminderMode reminderMode){

        switch(reminderMode){
            case alarm: return "alarm";
            case vibration: return "vibration";
            case both: return "both";
        }

        return "";
    }


    @TypeConverter
    public ReminderMode convertToEnum(String x){

        switch (x){
            case "alarm": return ReminderMode.alarm;
            case "vibration": return ReminderMode.vibration;
            case "both": return ReminderMode.both;
        }

        return ReminderMode.valueOf(x);
    }

}

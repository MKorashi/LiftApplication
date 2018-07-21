package com.example.dell.lift.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.dell.lift.Duration;

/**
 * Created by Dell on 23-Aug-17.
 */

public class DurationConverter {

    @TypeConverter
    public String convertToString(Duration duration){

        switch (duration){
            case NoEndDate: return "No End Date";
            case UntilDate:return "Until Date";
            case ForXDays:return "For x days";
        }


        return "";
    }

    @TypeConverter
    public Duration convertToEnum(String x){

        switch(x){
            case "No End Date": return Duration.NoEndDate;
            case "Until Date": return Duration.UntilDate;
            case "For x days": return Duration.ForXDays;
        }
    return Duration.valueOf(x);

    }

}

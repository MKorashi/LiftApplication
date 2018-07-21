package com.example.dell.lift.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.dell.lift.IntakeFrequency;

/**
 * Created by Dell on 23-Aug-17.
 */

public class IntakeFrequencyConverter {

    @TypeConverter
    public String convertToString(IntakeFrequency intakeFrequency){

        switch (intakeFrequency){

            case daily_x_times_a_day: return "daily x times a day";
            case daily_every_x_hours: return "daily every x hours";
            case specific_days_of_the_week: return "specific days of the week";

        }

        return "";
    }

    @TypeConverter
    public IntakeFrequency convertToEnum(String x){
        switch (x){
            case "daily x times a day": return IntakeFrequency.daily_x_times_a_day;
            case "daily every x hours":return IntakeFrequency.daily_every_x_hours;
            case "specific days of the week": return IntakeFrequency.specific_days_of_the_week;
            default: return IntakeFrequency.valueOf(x);
        }
        //   return IntakeFrequency.valueOf(x); ;
    }
}

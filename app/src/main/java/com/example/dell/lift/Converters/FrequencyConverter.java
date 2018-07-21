package com.example.dell.lift.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.dell.lift.Frequency;

/**
 * Created by Dell on 23-Aug-17.
 */

public class FrequencyConverter {

    @TypeConverter
    public String convertToString(Frequency frequency){

        switch(frequency){
            case   every_x_days: return "every x days";
            case   specific_days_of_the_week: return "specific days of the week";
            case   specific_days_of_the_month: return "specific days of the month";
            case   monthly: return "monthly";
            case   every_x_months: return "every x months";
        }

        return "";
    }


    @TypeConverter
    public Frequency convertToEnum(String x){

        switch(x){
            case   "every x days": return Frequency.every_x_days;
            case   "specific days of the week": return Frequency.specific_days_of_the_week;
            case   "specific days of the month": return Frequency.specific_days_of_the_month;
            case   "monthly": return Frequency.monthly;
            case   "every x months": return Frequency.every_x_months;
        }

    return Frequency.valueOf(x);
    }
}

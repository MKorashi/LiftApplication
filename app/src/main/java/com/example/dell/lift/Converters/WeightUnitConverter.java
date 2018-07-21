package com.example.dell.lift.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.dell.lift.WeightUnit;

/**
 * Created by Dell on 23-Aug-17.
 */

public class WeightUnitConverter {

    @TypeConverter
    public String convertToString(WeightUnit weightUnit){

        switch(weightUnit){
            case kg: return "kg";
            case lb: return "lb";

        }

        return "";
    }

    @TypeConverter
    public WeightUnit convertToEnum(String x){

        switch(x){

            case "kg": return WeightUnit.kg;
            case "lb": return WeightUnit.lb;

        }
        return WeightUnit.valueOf(x);
    }

}

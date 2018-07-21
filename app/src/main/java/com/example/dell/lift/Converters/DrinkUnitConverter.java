package com.example.dell.lift.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.dell.lift.DrinkUnit;

/**
 * Created by Dell on 23-Aug-17.
 */

public class DrinkUnitConverter {



    @TypeConverter
    public String convertToString(DrinkUnit drinkUnit){

        switch(drinkUnit){
            case  ml: return "ml";
            case  oz: return "oz";
            case  cl: return "cl";

        }

        return "";
    }


    @TypeConverter
    public DrinkUnit convertToEnum(String x){
        switch(x){
            case  "ml": return DrinkUnit.ml;
            case  "oz": return DrinkUnit.oz;
            case  "cl": return DrinkUnit.cl;

        }

        return DrinkUnit.valueOf(x);
    }
}

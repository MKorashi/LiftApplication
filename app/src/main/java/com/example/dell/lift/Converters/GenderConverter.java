package com.example.dell.lift.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.dell.lift.Gender;

/**
 * Created by Dell on 23-Aug-17.
 */

public class GenderConverter {

    @TypeConverter
    public String convertToString(Gender gender){

        switch(gender){
            case Female: return "female";
            case Male: return "male";
            case Other: return "other";

        }
        return "";

    }

    @TypeConverter
    public Gender convertToEnum(String x){
        switch (x){
            case "female": return Gender.Female;
            case "male":return Gender.Male;
            case "other":return Gender.Other;
            default:
        }
        return Gender.Other;
    }

}

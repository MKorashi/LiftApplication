package com.example.dell.lift;

import android.arch.persistence.room.TypeConverter;

import static com.example.dell.lift.Gender.Female;

/**
 * Created by Dell on 22-Aug-17.
 */

public class EnumConverter {

    @TypeConverter
   public String convertToString(SelfLogMoodFragment x){

        switch(x){
            case First: return "first";
            case Second: return "second";
            case Third: return "third";
            case Fourth: return "fourth";
        }

        return "";
    }

}

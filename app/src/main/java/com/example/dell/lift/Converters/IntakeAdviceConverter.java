package com.example.dell.lift.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.dell.lift.IntakeAdvice;

/**
 * Created by Dell on 23-Aug-17.
 */

public class IntakeAdviceConverter {


    @TypeConverter
    public String convertToString(IntakeAdvice intakeAdvice){
        switch(intakeAdvice){
            case None: return "None";
            case    BeforeMeal: return "Before Meal";
            case WithMeal: return "WithMeal";
            case AfterMeal: return "AfterMeal";
            case CustomEntry: return "CustomEntry";
        }
        return "";
    }


    @TypeConverter
    public IntakeAdvice convertToEnum(String x){

        switch ( x){
            case "None": return IntakeAdvice.None;
            case "Before Meal": return IntakeAdvice.BeforeMeal;
            case "WithMeal": return IntakeAdvice.WithMeal;
            case "AfterMeal": return IntakeAdvice.AfterMeal;
            case "CustomEntry": return IntakeAdvice.CustomEntry;
        }

        return IntakeAdvice.valueOf(x);
    }






}

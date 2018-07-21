package com.example.dell.lift.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.dell.lift.Relationship;

/**
 * Created by Dell on 23-Aug-17.
 */

public class RelationshipConverter {

    @TypeConverter
    public String convertToString(Relationship relationship){


        switch(relationship){
            case Doctor: return "Doctor";
            case Friend: return "Friend";
            case Partner: return "Partner";
        }

        return "";
    }

    @TypeConverter
    public Relationship convertToEnum(String x){

        switch(x){

            case "Doctor": return Relationship.Doctor;
            case "Friend": return Relationship.Friend;
            case "Partner": return Relationship.Partner;

        }

        return Relationship.valueOf(x);

    }
}

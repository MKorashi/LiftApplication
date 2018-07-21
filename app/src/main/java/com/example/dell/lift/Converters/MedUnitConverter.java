package com.example.dell.lift.Converters;

import android.arch.persistence.room.TypeConverter;

import com.example.dell.lift.Unit;

/**
 * Created by Dell on 23-Aug-17.
 */

public class MedUnitConverter {

    @TypeConverter
    public String convertToString(Unit x){

        switch(x){
            case tablets: return "tablets";
            case     drops: return "drops";
            case   ampoules: return "ampoules";
            case  applications: return "applications";
            case   millilitres: return "millilitres";
            case   grams: return "grams";
            case    suppository: return "suppository";
            case    pieces: return "pieces";
            case   units: return "units";
            case   milligrams: return "milligrams";
            case   capsules: return "capsules";
            case   puffs: return "puffs";
        }

        return "";
    }

    @TypeConverter
    public Unit convertToEnum(String x){

        switch(x){

            case  "tablets": return Unit.tablets;
            case   "drops":return Unit.drops;
            case   "ampoules": return Unit.ampoules;
            case  "applications": return Unit.applications;
            case    "millilitres": return Unit.millilitres;
            case   "grams": return Unit.grams;
            case    "suppository":return Unit.suppository ;
            case     "pieces": return Unit.pieces;
            case  "units": return Unit.units;
            case    "milligrams": return Unit.milligrams;
            case   "capsules": return Unit.capsules;
            case  "puffs": return Unit.puffs;
        }

        return Unit.valueOf( x);
    }
}

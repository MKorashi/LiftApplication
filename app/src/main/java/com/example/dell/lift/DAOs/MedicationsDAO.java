package com.example.dell.lift.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.dell.lift.Entities.Medication;

import java.util.ArrayList;

/**
 * Created by Dell on 22-Aug-17.
 */

@Dao
public interface MedicationsDAO {
//medications

    @Insert
    void create(Medication medication);

    @Delete
    void delete(Medication medication);

    @Delete
    void deleteAll(Medication... medications);

    @Query("SELECT * from medications WHERE user_id LIKE :user_id")
    ArrayList<Medication> getMedicationsByUserID (int user_id);

    @Query("SELECT * from medications WHERE med_id LIKE :med_id")
    ArrayList<Medication> getMedicationsByMedID(int med_id);


}

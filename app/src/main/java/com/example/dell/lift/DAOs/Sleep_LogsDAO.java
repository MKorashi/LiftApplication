package com.example.dell.lift.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.dell.lift.Entities.Sleep_Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 22-Aug-17.
 */

@Dao
public interface Sleep_LogsDAO {


    @Insert
    void create(Sleep_Log sleep_log);

    @Delete
    void delete(Sleep_Log sleep_log);

    @Delete
    void deleteAll(Sleep_Log... sleep_logs);

    @Query("SELECT * from sleep_logs WHERE email LIKE :email")
    List<Sleep_Log> getLogByUserID(String email);

    @Query("SELECT * from sleep_logs WHERE date LIKE :date")
    Sleep_Log getLogByDate(String date);


}

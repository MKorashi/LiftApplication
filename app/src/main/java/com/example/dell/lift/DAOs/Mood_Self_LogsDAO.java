package com.example.dell.lift.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.dell.lift.Entities.Mood_Self_Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 22-Aug-17.
 */

@Dao
public interface Mood_Self_LogsDAO {
    //mood_self_logs


    @Insert
    void create(Mood_Self_Log mood_self_log);

    @Insert
    void insertAll(Mood_Self_Log...mood_self_logs);

    @Delete
    void delete(Mood_Self_Log mood_self_log);

    @Delete
    void deleteAll(Mood_Self_Log... mood_self_logs);

    @Query("SELECT * from mood_self_logs WHERE email LIKE :email")
    List<Mood_Self_Log> getLogByUserID(String email);

    @Query("SELECT * from mood_self_logs WHERE dateTime LIKE :dateTime")
    Mood_Self_Log getLogByDate(String dateTime);



}

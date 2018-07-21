package com.example.dell.lift.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.dell.lift.Entities.User;

import java.util.ArrayList;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Dell on 22-Aug-17.
 */


@Dao
public interface UsersDAO {


    @Query("SELECT * FROM users")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM users where email LIKE  :email")
    User findByID(String email);


    @Query("SELECT COUNT(*) from users")
    int countUsers();

    @Insert(onConflict = REPLACE)
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Delete
    void delete(User... users);

    @Insert(onConflict = REPLACE)
    void create(User user);

}

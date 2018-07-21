package com.example.dell.lift.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.dell.lift.Entities.AlcoholDrink;
import com.example.dell.lift.Entities.User;

import java.util.List;

/**
 * Created by Dell on 22-Aug-17.
 */

@Dao
public interface Alcohol_DrinksDAO {

    @Query("SELECT * FROM alcohol_drinks")
    List<AlcoholDrink> getAll();

    @Query("SELECT * FROM alcohol_drinks where email LIKE  :email")
    List<AlcoholDrink> findDrinksByUserID(String email);


    @Query("SELECT * FROM alcohol_drinks where drink_id LIKE :drink_id")
    AlcoholDrink findDrinkByID(int drink_id);


    @Query("SELECT COUNT(*) from alcohol_drinks")
    int countAlcoholDrinks();

    @Insert
    void insertAll(AlcoholDrink... alcoholDrinks);

    @Delete
    void delete(AlcoholDrink alcoholDrink);

    @Delete
    void delete(AlcoholDrink... alcoholDrinks);

    @Insert
    void create(AlcoholDrink alcoholDrink);





}

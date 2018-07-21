package com.example.dell.lift.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.dell.lift.Entities.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 22-Aug-17.
 */

@Dao
public interface ContactsDAO {
    //contacts

    @Insert
    void create(Contact contact);

    @Delete
    void delete(Contact contact);

    @Insert
    void insertAll(Contact... contacts);

    @Query("SELECT * FROM contacts where user_email LIKE  :email")
    List<Contact> findContactsByUserID(String email);




}

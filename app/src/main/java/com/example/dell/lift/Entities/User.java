package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.example.dell.lift.Converters.GenderConverter;
import com.example.dell.lift.Converters.WeightUnitConverter;
import com.example.dell.lift.DateConverter;
import com.example.dell.lift.EnumConverter;
import com.example.dell.lift.Gender;
import com.example.dell.lift.WeightUnit;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dell on 30-Jul-17.
 */

@Entity(tableName = "users")
public class User {


    @PrimaryKey
    private String email;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "date_of_birth")
    private String date_of_birth;

    @ColumnInfo(name = "password_hash")
    private String password_hash;

    @TypeConverters(GenderConverter.class)
    private Gender gender;

    @ColumnInfo(name = "weight")
    private float weight;

    @TypeConverters(WeightUnitConverter.class)
    private WeightUnit weightUnit;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "icd_10")
    private String ICD_10;

    @ColumnInfo(name = "createdAt")
    private String createdAt; //default to now

    @ColumnInfo(name = "updatedAt")
    private String updatedAt;

    @ColumnInfo(name = "last_login")
    private String last_login; //lama y-login


    @ColumnInfo(name = "salt")
    private String salt;


    public User() {

    }


    @Ignore
    public User(String email, String name, String date_of_birth, String password_hash, Gender gender, float weight,
                WeightUnit weightUnit, String country, String ICD_10, String salt) {
        this.email = email;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.password_hash = password_hash;
        this.gender = gender;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.country = country;
        this.ICD_10 = ICD_10;
        this.createdAt = new SimpleDateFormat("dd-mm-yy").format(new Date());

        this.salt = salt;
    }

    @Ignore
    public User(String email, String name, String date_of_birth, String password_hash,
                Gender gender, String country, String icd_10, String salt) {
        this.name = name;
        this.password_hash = password_hash;
        this.salt = salt;
        this.gender = gender;
        this.country = country;
        this.ICD_10 = icd_10;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.createdAt = new SimpleDateFormat("dd-mm-yy").format(new Date());

    }

    @Ignore
    public User(String email, Gender gender, String password_hash, float weight, WeightUnit weightUnit, String salt) {
        this.email = email;
        this.gender = gender;
        this.password_hash = password_hash;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.createdAt = new SimpleDateFormat("dd-mm-yy").format(new Date());
        this.salt = salt;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getICD_10() {
        return ICD_10;
    }

    public void setICD_10(String ICD_10) {
        this.ICD_10 = ICD_10;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}

package com.example.dell.lift.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.example.dell.lift.Converters.RelationshipConverter;
import com.example.dell.lift.EnumConverter;
import com.example.dell.lift.Relationship;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Dell on 10-Aug-17.
 */
@Entity(tableName = "contacts", primaryKeys = {"user_email", "contact_email"},
        foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "email", childColumns = "user_email", onDelete = CASCADE, onUpdate = CASCADE)})
public class Contact {

@ColumnInfo(name = "user_email")
    private String user_email;

    @ColumnInfo(name = "contact_email")
    private String contact_email;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "phoneNumber")
    private int phone_number;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "addedAt")
    private String addedAt; //default to now

    @ColumnInfo(name = "deletedAt")
    private String deletedAt;

    @ColumnInfo(name = "updatedAt")
    private String updatedAt;

    @ColumnInfo(name = "lastUpdateSent")
    private String lastupdateSent; //last update sent

    @TypeConverters(RelationshipConverter.class)
    private Relationship relationship;


    public String getUser_email() {
        return this.user_email;
    }


    public void setUser_email(String email) {
    this.user_email = email;
   }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String email) {
        this.contact_email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }



	//	t.uuid('user_id');
  	//	t.foreign('user_id').references('users.id');

    public String getLastupdateSent() {
        return lastupdateSent;
    }

    public void setLastupdateSent(String lastupdateSent) {
        this.lastupdateSent = lastupdateSent;
    }

}

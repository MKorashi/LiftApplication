package com.example.dell.lift;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.dell.lift.DAOs.Alcohol_DrinksDAO;
import com.example.dell.lift.DAOs.Alcohol_Drinks_HadDAO;
import com.example.dell.lift.DAOs.ContactsDAO;
import com.example.dell.lift.DAOs.Mood_Self_LogsDAO;
import com.example.dell.lift.DAOs.Sleep_LogsDAO;
import com.example.dell.lift.DAOs.UsersDAO;
import com.example.dell.lift.Entities.AlcoholDrink;
import com.example.dell.lift.Entities.Alcohol_Drinks_Had;
import com.example.dell.lift.Entities.Alcohol_Presets;
import com.example.dell.lift.Entities.Auto_Image_Mood_Log;
import com.example.dell.lift.Entities.Auto_Text_Mood_Log;
import com.example.dell.lift.Entities.Contact;
import com.example.dell.lift.Entities.Measurement;
import com.example.dell.lift.Entities.Measurement_Reminder_Days;
import com.example.dell.lift.Entities.Measurement_Reminder_Months;
import com.example.dell.lift.Entities.Measurements_Data;
import com.example.dell.lift.Entities.Measurements_Reminder;
import com.example.dell.lift.Entities.Medication;
import com.example.dell.lift.Entities.Medication_Details;
import com.example.dell.lift.Entities.Medication_Group;
import com.example.dell.lift.Entities.Medication_Group_Reminder;
import com.example.dell.lift.Entities.Medication_Group_Reminder_Days;
import com.example.dell.lift.Entities.Medication_Group_Reminder_Log;
import com.example.dell.lift.Entities.Medication_Group_Reminder_Times;
import com.example.dell.lift.Entities.Medication_Reminder;
import com.example.dell.lift.Entities.Medication_Reminder_Days;
import com.example.dell.lift.Entities.Medication_Reminder_Log;
import com.example.dell.lift.Entities.Medication_Reminder_Times;
import com.example.dell.lift.Entities.Medications_History;
import com.example.dell.lift.Entities.Medications_Per_Med_Group;
import com.example.dell.lift.Entities.Mood_Self_Log;
import com.example.dell.lift.Entities.Sleep_Log;
import com.example.dell.lift.Entities.User;

/**
 * Created by Dell on 22-Aug-17.
 */

@Database(entities = {User.class, AlcoholDrink.class, Alcohol_Drinks_Had.class, Alcohol_Presets.class,
Contact.class, Sleep_Log.class, Mood_Self_Log.class, Auto_Text_Mood_Log.class,
Medication_Group.class, Medications_Per_Med_Group.class, Medications_History.class, Medication_Group_Reminder.class,
Medication_Group_Reminder_Log.class, Medication_Group_Reminder_Days.class, Medication_Group_Reminder_Times.class,
Measurement.class, Measurements_Data.class, Measurements_Reminder.class, Measurement_Reminder_Days.class, Measurement_Reminder_Months.class,
Medication.class, Medication_Details.class, Medication_Reminder.class, Medication_Reminder_Log.class, Medication_Reminder_Days.class,
Medication_Reminder_Times.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app_db")
                            .build();
        }
        return INSTANCE;
    }


//    public abstract BorrowModelDao itemAndPersonModel();

    public abstract UsersDAO getUsersDao();

    public abstract Alcohol_DrinksDAO getAlcoholDrinksDao();

    public abstract Alcohol_Drinks_HadDAO getAlcoholDrinksHadDao();

    public abstract ContactsDAO getContactsDao();

    public abstract Sleep_LogsDAO getSleepLogsDao();

    public abstract Mood_Self_LogsDAO getMoodSelfLogsDao();

}

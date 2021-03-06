package com.example.dell.lift;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.preference.PreferenceManager;

/**
 * Created by Dell on 03-Aug-17.
 */

public class Utility {
    public static Boolean isUserLoggedIn(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        return prefs.getBoolean("isUserLoggedIn", false);
    }

    public static void setUserLoggedIn(Context context, Boolean isLoggedIn)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("isUserLoggedIn", isLoggedIn);
        editor.commit();
    }

    public static void logout(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("isUserLoggedIn", false);
        editor.commit();
    }

    public static void saveUsernameAndPassword(Context context, String username, String password)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
    }
}
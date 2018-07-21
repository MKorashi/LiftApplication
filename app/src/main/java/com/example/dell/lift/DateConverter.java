package com.example.dell.lift;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Dell on 22-Aug-17.
 */

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}

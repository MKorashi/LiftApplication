package com.example.dell.lift;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dell on 16-Aug-17.
 */

public class MyDate extends Date {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /*
     * additional constructors
     */

    @Override
    public String toString() {
        return dateFormat.format(this);
    }
}

package org.advancedjava.lombokdemo;

import lombok.experimental.UtilityClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class DateUtil {

    public String format(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        return dateFormat.format(date);
    }
}
/*
The @UtilityClass annotation in Lombok is used to simplify the creation of utility classes.
Utility classes typically consist of only static methods and fields, with a private constructor
to prevent instantiation. By using @UtilityClass, Lombok automatically makes all methods and
fields static and generate a private constructor, preventing instantiation of the class.
Also it makes the class final.
 */

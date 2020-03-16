package io.dualbit.wordpressclient.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static String format = "yyyy-MM-dd'T'hh:mm:ss";
    private static DateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());

    public static Date parseISO8601(String date) {
        Date dateObject = null;
        try {
            dateObject = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateObject;
    }

    public static String parseISO8601(Date date) {
        return dateFormat.format(date);
    }
}

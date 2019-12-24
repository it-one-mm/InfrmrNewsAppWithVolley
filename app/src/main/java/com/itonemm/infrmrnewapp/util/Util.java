package com.itonemm.infrmrnewapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String DateFormatted(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=null;
        date1=simpleDateFormat.parse(date);
        return date.toString();
    }

}

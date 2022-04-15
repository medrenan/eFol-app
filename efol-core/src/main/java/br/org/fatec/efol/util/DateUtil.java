package br.org.fatec.efol.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String PT_BR_DATE_FORMAT = "dd/MM/yyyy";

    public static Date parseDatePtBr(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(PT_BR_DATE_FORMAT);
        return format.parse(date);
    }

    public static String toPtBr(Date date) {
        if(date == null){
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(PT_BR_DATE_FORMAT);
        return sdf.format(date);
    }
}

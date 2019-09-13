package com.ingenico.epayments.jarrs.hackaton.oqp.converter;

import androidx.room.TypeConverter;

import java.math.BigDecimal;

/**
 * Convertors for saving and retrieving complex fields into Room database
 */
public class Converters {

    @TypeConverter
    public BigDecimal fromLong(Long value) {
        return value == null ? null : new BigDecimal(value).divide(new BigDecimal(100));
    }

    @TypeConverter
    public Long toLong(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null;
        } else {
            return bigDecimal.multiply(new BigDecimal(100)).longValue();
        }
    }

//    @TypeConverter
//    public static LocalTime toTime(String timeString) {
//        if (timeString == null) {
//            return null;
//        } else {
//            return ;
//        }
//    }
//
//    @TypeConverter
//    public static String toTimeString(LocalTime time) {
//        if (time == null) {
//            return null;
//        } else {
//            ;
//            return System.currentTimeMillis().;
//        }
//    }


}

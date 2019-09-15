package com.ingenico.epayments.jarrs.hackaton.oqp.converter;

import androidx.room.TypeConverter;

import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.math.BigDecimal;

/**
 * Convertors for saving and retrieving complex fields into Room database
 */
public class Converters {
    // formatter for transactiondates
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    // converters BigDecimal amount into Long amount and vice versa for Room storage
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

    @TypeConverter
    public OffsetDateTime toOffsetDateTime(String value) {
        if (value == null) {
            return null;
        } else {
            return dateTimeFormatter.parse(value, OffsetDateTime.FROM);
        }
    }

    @TypeConverter
    public String fromOffsetDateTime(OffsetDateTime dateTime) {
        if (dateTime == null) {
            return null;
        } else {
            return dateTime.format(dateTimeFormatter);
        }

    }


}

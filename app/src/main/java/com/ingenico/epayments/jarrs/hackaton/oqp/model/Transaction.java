package com.ingenico.epayments.jarrs.hackaton.oqp.model;

import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.ingenico.epayments.jarrs.hackaton.oqp.converter.Converters;

import org.threeten.bp.OffsetDateTime;

import java.math.BigDecimal;

import lombok.Data;

@Data
@Entity(tableName = "transactions")
@TypeConverters(Converters.class)
public class Transaction {

    @PrimaryKey
    @SerializedName("id")
    private Long id;

    @NonNull
    @SerializedName("uuid")
    private String uuid;

    @NonNull
    @SerializedName("sender")
    @Size(min = 1, max = 100)
    private String sender;

    @NonNull
    @Size(min = 1, max = 100)
    @SerializedName("receiver")
    private String receiver;

    @NonNull
    @SerializedName("transactionTime")
    private OffsetDateTime transactionTime;

    @NonNull
    @SerializedName("amount")
    private BigDecimal amount;

    @NonNull
    @Size(min = 3, max = 3)
    @SerializedName("currency")
    private String currency;

    @SerializedName("senderUpdateTime")
    private OffsetDateTime senderUpdateTime;

    @SerializedName("receiverUpdateTime")
    private OffsetDateTime receiverUpdateTime;
}

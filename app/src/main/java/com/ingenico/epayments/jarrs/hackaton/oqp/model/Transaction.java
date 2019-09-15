package com.ingenico.epayments.jarrs.hackaton.oqp.model;

import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.threeten.bp.OffsetDateTime;

import java.math.BigDecimal;

import lombok.Data;

@Data
@Entity(tableName = "transactions")
public class Transaction {

    @PrimaryKey
    private Long id;

    @NonNull
    private String uuid;

    @NonNull
    @Size(min = 1, max = 100)
    private String sender;

    @NonNull
    @Size(min = 1, max = 100)
    private String receiver;

    @NonNull
    private OffsetDateTime transactionTime;

    @NonNull
    private BigDecimal amount;

    @NonNull
    @Size(min = 3, max = 3)
    private String currency;

    private OffsetDateTime senderUpdateTime;

    private OffsetDateTime receiverUpdateTime;
}

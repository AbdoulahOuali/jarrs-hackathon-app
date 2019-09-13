package com.ingenico.epayments.jarrs.hackaton.oqp.model;

import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.BigDecimal;

import lombok.Data;


@Data
@Entity(tableName = "user_table")
public class User {

    @PrimaryKey
    private Long id;

    @NonNull
    @Size(min = 1, max = 100)
    private String userId;

    @NonNull
    @Size(min = 1, max = 100)
    private String firstName;

    @NonNull
    @Size(min = 1, max = 100)
    private String lastName;

    @NonNull
    @Size(min = 1, max = 100)
    private String email;

    @NonNull
    private BigDecimal balance;

    @NonNull
    @Size(min = 3, max = 3)
    private String currency;

}

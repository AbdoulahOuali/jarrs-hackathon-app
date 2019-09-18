package com.ingenico.epayments.jarrs.hackaton.oqp.model;

import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

import lombok.Data;


@Data
@Entity(tableName = "users", indices = @Index(value = "user_id", unique = true))
public class User {

    @PrimaryKey
    private Long id;

    @NonNull
    @SerializedName("userId")
    @ColumnInfo(name = "user_id")
    @Size(min = 1, max = 100)
    private String userId;

    @NonNull
    @ColumnInfo(name = "first_name")
    @Size(min = 1, max = 100)
    private String firstName;

    @NonNull
    @ColumnInfo(name = "last_name")
    @Size(min = 1, max = 100)
    private String lastName;

    @NonNull
    @ColumnInfo(name = "email")
    @Size(min = 1, max = 100)
    private String email;

    @NonNull
    private BigDecimal balance;

    @NonNull
    @Size(min = 3, max = 3)
    private String currency;

}

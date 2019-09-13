package com.ingenico.epayments.jarrs.hackaton.oqp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ingenico.epayments.jarrs.hackaton.oqp.model.Transaction;
import com.ingenico.epayments.jarrs.hackaton.oqp.model.User;

import java.util.List;

@Dao
public interface TransactionDao {

    @Insert
    void add(Transaction transaction);

    @Update
    void update(Transaction transaction);

    @Delete
    void delete(Transaction transaction);

    @Query("SELECT * FROM transaction_table ORDER BY transactionTime DESC")
    List<User> getAllTransaction();
}

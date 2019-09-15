package com.ingenico.epayments.jarrs.hackaton.oqp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ingenico.epayments.jarrs.hackaton.oqp.model.Transaction;

@Dao
public interface TransactionDao {

    @Insert
    void insert(Transaction transaction);

    @Update
    void update(Transaction transaction);

    @Delete
    void delete(Transaction transaction);

    @Query("SELECT * FROM transactions WHERE id =:id")
    LiveData<Transaction> getTransactionById(Long id);

    // TODO foreignkey mapping

//    @Query("SELECT users.userId, " +
//            "transactions.* " +
//            "FROM users " +
//            "INNER JOIN transactions ON userId = receiver OR userId = sender")
//    LiveData<List<Transaction>> getAllTransactionsForUser(String userId);
//
//    @Query("SELECT users.userId, " +
//            "transactions.* " +
//            "FROM users " +
//            "INNER JOIN transactions ON userId = receiver")
//    LiveData<List<Transaction>> getAllReceivedTransactionsForUser(String userId);
//
//    @Query("SELECT users.userId, " +
//            "transactions.* " +
//            "FROM users " +
//            "INNER JOIN transactions ON userId = sender")
//    LiveData<List<Transaction>> getAllSentTransactionsForUser(String userId);
}

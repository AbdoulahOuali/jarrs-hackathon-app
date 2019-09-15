package com.ingenico.epayments.jarrs.hackaton.oqp.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.ingenico.epayments.jarrs.hackaton.oqp.dao.TransactionDao;
import com.ingenico.epayments.jarrs.hackaton.oqp.dao.UserDao;
import com.ingenico.epayments.jarrs.hackaton.oqp.database.AppDatabase;
import com.ingenico.epayments.jarrs.hackaton.oqp.model.Transaction;

import java.util.List;

public class TransactionRepository {

    private TransactionDao transactionDao;
    private UserDao userDao;
    private LiveData<Transaction> transaction;
    private LiveData<List<Transaction>> allTransactions;

    public TransactionRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getAppDBInstance(application);
        transactionDao = appDatabase.TransactionDao();
        userDao = appDatabase.userDao();

//   TODO     allTransactions = transactionDao.getAllTransactionsForUser();
    }

    private void insert(final Transaction transaction) {
        new AsyncTask<Transaction, Void, Void>() {
            @Override
            protected Void doInBackground(Transaction... transactions) {
                transactionDao.insert(transaction);
                return null;
            }
        }.execute();
    }

    private void update(Transaction transaction) {

    }

    private void delete(Transaction transaction) {

    }

    private void deleteAllTransactions() {

    }

    public LiveData<Transaction> getTransaction(Long id) {
        return transactionDao.getTransactionById(id);
    }

    public LiveData<List<Transaction>> getAllTransactions() {
        return allTransactions;
    }
}

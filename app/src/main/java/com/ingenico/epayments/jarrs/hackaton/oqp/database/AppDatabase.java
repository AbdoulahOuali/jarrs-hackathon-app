package com.ingenico.epayments.jarrs.hackaton.oqp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.ingenico.epayments.jarrs.hackaton.oqp.converter.Converters;
import com.ingenico.epayments.jarrs.hackaton.oqp.dao.TransactionDao;
import com.ingenico.epayments.jarrs.hackaton.oqp.dao.UserDao;
import com.ingenico.epayments.jarrs.hackaton.oqp.model.Transaction;
import com.ingenico.epayments.jarrs.hackaton.oqp.model.User;

@Database(entities = {User.class, Transaction.class}, version = 1)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {

    //singleton db instance
    private static AppDatabase appDBInstance;

    public abstract UserDao userDao();

    public abstract TransactionDao TransactionDao();

    /**
     * builds a singleton database instance, Allows Room to destructively recreate database tables if migrations are not
     * available when downgrading to old schema versions.
     */
    public static synchronized AppDatabase getAppDBInstance(Context context) {
        if (appDBInstance == null) {
            appDBInstance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDBInstance;
    }
}

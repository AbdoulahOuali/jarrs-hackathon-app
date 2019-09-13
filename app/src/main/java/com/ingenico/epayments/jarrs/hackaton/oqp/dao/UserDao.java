package com.ingenico.epayments.jarrs.hackaton.oqp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ingenico.epayments.jarrs.hackaton.oqp.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void add(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user_table ORDER BY userId DESC")
    List<User> getAllUsers();
}

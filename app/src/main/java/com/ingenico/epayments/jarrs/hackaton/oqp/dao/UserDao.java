package com.ingenico.epayments.jarrs.hackaton.oqp.dao;

import androidx.lifecycle.LiveData;
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

    @Query("SELECT * FROM users ORDER BY user_id DESC")
    List<User> getAllUsers();

    @Query("SELECT * FROM users WHERE user_id =:usrId")
    LiveData<User> getUserById(String usrId);
}

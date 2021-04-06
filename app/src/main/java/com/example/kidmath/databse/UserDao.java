package com.example.kidmath.databse;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * From user")
    List<User> getAll();
    @Insert
    void insertAll(User... users);

}

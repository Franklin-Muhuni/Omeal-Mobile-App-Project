package com.example.omealappproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProfileDao {
    @Insert
    void insertAll(Profile... profiles);

    @Query("SELECT * FROM profile")
    List<Profile> getAllProfiles();
}

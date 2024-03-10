package com.example.omealappproject;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Profile.class}, version = 1)
public abstract class ProfileDatabase extends RoomDatabase {
    public abstract ProfileDao profileDao();
}

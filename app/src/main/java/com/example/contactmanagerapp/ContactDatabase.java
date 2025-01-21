package com.example.contactmanagerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contacts.class}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {

    public abstract ContactDAO getContactDao();

    // Singleton instance
    private static volatile ContactDatabase dbInstance;

    public static synchronized ContactDatabase getInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ContactDatabase.class, "contacts_db"
                    )
                    .fallbackToDestructiveMigration() // Ensure to replace this with migrations in production
                    .build();
        }
        return dbInstance;
    }
}


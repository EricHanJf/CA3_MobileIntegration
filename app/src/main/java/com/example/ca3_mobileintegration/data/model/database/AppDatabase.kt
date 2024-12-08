package com.example.ca3_mobileintegration.data.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = [User::class], version = 1)
@Database(entities = [User::class, Plant::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    // Access the UserDao
    abstract fun userDao(): UserDao
    abstract fun plantDao(): PlantDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
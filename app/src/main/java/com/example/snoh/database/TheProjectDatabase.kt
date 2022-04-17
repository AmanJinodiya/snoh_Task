package com.example.snoh.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.snoh.ui.home.HomeFragment


@Database(entities = [TheProject::class], version = 1, exportSchema = false)
abstract class TheProjectDatabase : RoomDatabase() {

    abstract fun theproject_DAO() : TheProject_DAO

    companion object{
        @Volatile
        private var Instance : TheProjectDatabase ?= null

        fun getDatabase(context: Context): TheProjectDatabase
        {
            if(Instance == null)
            {
                synchronized(this)
                {
                    Instance = Room.databaseBuilder(context.applicationContext,
                                    TheProjectDatabase::class.java,
                                    "yes_thats_me").build()
                }
            }
            return Instance!!
        }
    }
}
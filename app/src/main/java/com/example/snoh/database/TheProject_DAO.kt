package com.example.snoh.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TheProject_DAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE )
    suspend fun insertdata(obj : TheProject)

    @Update
    suspend fun updatedata(obj: TheProject)

    @Delete
    suspend fun deletedata(obj : TheProject)

    @Query("SELECT * FROM yes_thats_me")
    fun getdata() : LiveData<List<TheProject>>
}
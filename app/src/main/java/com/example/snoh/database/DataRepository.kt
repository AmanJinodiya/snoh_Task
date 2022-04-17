package com.example.snoh.database

import androidx.lifecycle.LiveData

class DataRepository(private var projDao :TheProject_DAO) {

    val readalldata : LiveData<List<TheProject>> = projDao.getdata()

    suspend fun adddata(theProject: TheProject)
    {
        projDao.insertdata(theProject)
    }


}
package com.example.snoh.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.snoh.database.DataRepository
import com.example.snoh.database.TheProject
import com.example.snoh.database.TheProjectDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {


    val readalldata : LiveData<List<TheProject>>
    val repository : DataRepository

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    init {
        val userdao = TheProjectDatabase.getDatabase(application).theproject_DAO()
        repository = DataRepository(userdao)
        readalldata = repository.readalldata
    }

    fun addData(theProject: TheProject)
    {
        viewModelScope.launch (Dispatchers.IO){
            repository.adddata(theProject)
        }
    }
}
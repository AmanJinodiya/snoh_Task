package com.example.snoh.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "yes_thats_me")
data class TheProject (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val logic : String
)

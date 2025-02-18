package com.smartlink.smartlinkapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class SampleEntity(
    @PrimaryKey val id: String,
    val name: String,
    val email: String
)
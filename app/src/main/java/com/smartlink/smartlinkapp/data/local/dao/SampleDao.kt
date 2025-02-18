package com.smartlink.smartlinkapp.data.local.dao

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import com.smartlink.smartlinkapp.data.local.entity.SampleEntity


@Dao
interface SampleDao {
    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUser(userId: String): SampleEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: SampleEntity)
}

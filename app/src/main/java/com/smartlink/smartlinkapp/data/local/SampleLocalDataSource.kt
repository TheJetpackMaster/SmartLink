package com.smartlink.smartlinkapp.data.local


import com.smartlink.smartlinkapp.data.local.dao.SampleDao
import com.smartlink.smartlinkapp.domain.model.User
import javax.inject.Inject

class SampleLocalDataSource @Inject constructor(
    private val userDao: SampleDao
) {

//    suspend fun getUser(userId: String): User {
//        return userDao.getUser(userId).toDomain()
//    }
//
//    suspend fun saveUser(user: User) {
//        userDao.saveUser(user.toEntity())
//    }
}

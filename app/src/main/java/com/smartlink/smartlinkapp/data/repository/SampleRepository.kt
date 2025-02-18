package com.smartlink.smartlinkapp.data.repository

import com.smartlink.smartlinkapp.data.remote.SampleRemoteDataSource;
import com.smartlink.smartlinkapp.domain.model.User
import com.smartlink.smartlinkapp.domain.repository.ISampleRepository

import javax.inject.Inject;

class SampleRepository @Inject constructor(
//    private val localDataSource: LocalDataSource,
    private val remoteDataSource:SampleRemoteDataSource
) : ISampleRepository {

//    override suspend fun getUser(userId: String): User {
//        return try {
//            val user = remoteDataSource.getUser(userId)
//            localDataSource.saveUser(user) // Cache locally
//            user
//        } catch (e: Exception) {
//            localDataSource.getUser(userId) // Return cached user if Firebase fails
//        }
//    }
//
//    override suspend fun updateUser(user: User) {
//        remoteDataSource.updateUser(user)
//        localDataSource.saveUser(user)
//    }
}

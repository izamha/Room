package com.therays.room.repository

import androidx.lifecycle.LiveData
import com.therays.room.data.UserDao
import com.therays.room.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    fun exists(firstName: String): Boolean {
        if (userDao.exists(firstName)){
            println("Sure, this name already exists.")
        }
         return false
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUsers() {
        userDao.deleteAll()
    }

}
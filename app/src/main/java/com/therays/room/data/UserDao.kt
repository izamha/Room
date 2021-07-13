package com.therays.room.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.therays.room.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Query("SELECT EXISTS (SELECT firstName FROM user_table WHERE firstName = :firstName)")
    fun exists(firstName: String): Boolean
}
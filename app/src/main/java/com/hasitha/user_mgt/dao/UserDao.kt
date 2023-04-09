package com.hasitha.user_mgt.dao

import androidx.room.*
import com.hasitha.user_mgt.entities.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun getUser(username: String): User?

    @Update
    suspend fun updateUser(user: User)
}
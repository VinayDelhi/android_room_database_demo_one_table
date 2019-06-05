package com.demo.roomdatabase.data.local.dao

import androidx.room.*
import com.demo.roomdatabase.data.local.entity.User
import io.reactivex.Single

/**
 * This class containes all the queries related to database
 * for User Entity.
 * */

@Dao
interface UserDao {

    @Insert
    fun inserUser(user: User): Single<Long> // emits a long, which is the new rowId for the inserted item

    @Update
    fun updateUser(user: User): Single<Int> // emits an int value, indicating the number of rows updated in the database.

    @Delete
    fun deleteUser(user: User): Single<Int> // emits an int value, indicating the number of rows removed from the database.

    @Query("SELECT count(*) FROM users")
    fun count(): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMany(vararg user: User): Single<List<Long>>

    @Query("SELECT * FROM users")
    fun getAllUsers(): Single<List<User>>

}
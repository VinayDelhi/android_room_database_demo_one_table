package com.demo.roomdatabase.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.roomdatabase.data.local.dao.UserDao
import com.demo.roomdatabase.data.local.entity.User
import com.demo.roomdatabase.di.ApplicationContext
import com.demo.roomdatabase.di.DatabaseInfo
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
@Database(entities = [
                      User::class
                     ],
                     exportSchema = false,
                     version = 1)
abstract class DatabaseService: RoomDatabase() {

    abstract fun getUserDao(): UserDao

}
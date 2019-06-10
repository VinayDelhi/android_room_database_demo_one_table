package com.demo.roomdatabase.di.modules

import android.content.Context
import androidx.room.Room
import com.demo.roomdatabase.MyApplication
import com.demo.roomdatabase.data.local.DatabaseService
import com.demo.roomdatabase.di.ApplicationContext
import com.demo.roomdatabase.di.DatabaseInfo
import com.demo.roomdatabase.di.NetworkInfo
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication){

    @Provides
    @ApplicationContext
    fun provideContext(): Context{
        return application
    }

    @Provides
    @NetworkInfo
    fun provideApiKey(): String{
        return "abc"
    }



    @Provides
    @Singleton
    fun provideRoomDatabase()  = Room.databaseBuilder(
                                  application,
                                  DatabaseService::class.java,
                                  "bootcamp-database-project-db"

                                ).build()
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}
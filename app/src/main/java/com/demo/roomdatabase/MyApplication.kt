package com.demo.roomdatabase

import android.app.Application
import android.util.Log
import com.demo.roomdatabase.data.local.DatabaseService
import com.demo.roomdatabase.data.remote.NetworkService
import com.demo.roomdatabase.di.components.ApplicationComponent
import com.demo.roomdatabase.di.components.DaggerActivityComponent
import com.demo.roomdatabase.di.components.DaggerApplicationComponent
import com.demo.roomdatabase.di.modules.ApplicationModule
import com.demo.roomdatabase.ui.main.MainViewModel
import com.demo.roomdatabase.utils.NetworkHelper
import javax.inject.Inject

class MyApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var databaseService: DatabaseService

    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var networkHelper: NetworkHelper

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies(){

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build();
        applicationComponent.inject(this)

        Log.d("DEBUG", databaseService.toString())
        Log.d("DEBUG", networkService.toString())

    }
}
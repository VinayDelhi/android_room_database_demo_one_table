package com.demo.roomdatabase.di.components

import android.content.Context
import com.demo.roomdatabase.MyApplication
import com.demo.roomdatabase.data.local.DatabaseService
import com.demo.roomdatabase.data.remote.NetworkService
import com.demo.roomdatabase.di.ApplicationContext
import com.demo.roomdatabase.di.modules.ApplicationModule
import com.demo.roomdatabase.ui.main.MainViewModel
import com.demo.roomdatabase.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(myApplication: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getNetworkHelper(): NetworkHelper

    fun getCompositeDisposable(): CompositeDisposable
}
package com.demo.roomdatabase.di.modules

import android.app.Activity
import android.content.Context
import com.demo.roomdatabase.di.ActivityContext
import com.demo.roomdatabase.ui.main.MainActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity)
{

    @Provides
    @ActivityContext
    fun provideContext(): Context{
        return activity
    }

}
package com.demo.roomdatabase.di.modules

import android.content.Context
import androidx.fragment.app.Fragment
import com.demo.roomdatabase.di.ActivityContext
import com.demo.roomdatabase.ui.home.HomeFragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    /*@Provides
    @ActivityContext
    fun provideContext(): Context {

        return fragment.context!!
    }*/

    // we can write this like:

    @Provides
    @ActivityContext
    fun provideContext(): Context = fragment.context!!

}
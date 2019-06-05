package com.demo.roomdatabase.di.components

import com.demo.roomdatabase.di.ActivityScope
import com.demo.roomdatabase.di.modules.ActivityModule
import com.demo.roomdatabase.ui.main.MainActivity
import dagger.Component
import dagger.Module


@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent{

    fun inject(mainActivity: MainActivity)

}
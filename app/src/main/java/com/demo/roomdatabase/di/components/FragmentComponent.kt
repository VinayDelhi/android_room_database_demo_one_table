package com.demo.roomdatabase.di.components

import com.demo.roomdatabase.di.FragmentScope
import com.demo.roomdatabase.di.modules.FragmentModule
import com.demo.roomdatabase.ui.home.HomeFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(homeFragment: HomeFragment)
}
package com.demo.roomdatabase.ui.home

import com.demo.roomdatabase.data.local.DatabaseService
import com.demo.roomdatabase.data.remote.NetworkService
import com.demo.roomdatabase.di.FragmentScope
import com.demo.roomdatabase.utils.NetworkHelper
import javax.inject.Inject

@FragmentScope
class HomeViewModel @Inject constructor(
                    private val databaseService: DatabaseService,
                    private val networkService: NetworkService,
                    private val networkHelper: NetworkHelper){


    val someData: String
     get() = "${networkService.dummyData}"

}
package com.demo.roomdatabase.data.remote

import android.content.Context
import com.demo.roomdatabase.di.ApplicationContext
import com.demo.roomdatabase.di.NetworkInfo
import java.security.AccessControlContext
import javax.inject.Inject
import javax.inject.Singleton

//inject allication context.

@Singleton
class NetworkService @Inject constructor(
    @ApplicationContext private val context: Context,
    @NetworkInfo private val apiKey: String ) {


    val dummyData:String

        get() = "NETWORK_DUMMY_DATA"

}
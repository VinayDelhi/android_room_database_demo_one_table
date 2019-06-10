package com.demo.roomdatabase.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.demo.roomdatabase.data.local.DatabaseService
import com.demo.roomdatabase.data.local.entity.User
import com.demo.roomdatabase.data.remote.NetworkService
import com.demo.roomdatabase.di.ActivityScope
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
             private val compositeDisposable: CompositeDisposable,
             private val networkService: NetworkService,
             private val databaseService: DatabaseService) {

    companion object{

        const val TAG = "MainViewModel"
    }

    val users = MutableLiveData<List<User>>()

    private var userList : List<User> = emptyList()


    // init block is called just after the primary constructor.
     init {

           compositeDisposable.add(
               databaseService.getUserDao()
                   .count()
                   .flatMap {
                       if(it == 0) // we are not write "return" here because in
                                   // the lamda last statement is return statement.
                           databaseService.getUserDao()
                               .insertMany(
                                   User(name = "Vinay", companyName = "Umbrella"),
                                   User(name = "Amit", companyName = "Mindork"),
                                   User(name = "Sunil", companyName = "NIC"),
                                   User(name = "Ali", companyName = "After Academy"),
                                   User(name = "Satya", companyName = "Naggaro"),
                                   User(name = "Manish", companyName = "Excel")
                               )

                     else Single.just(0)
                   }
                   .subscribeOn(Schedulers.io()) // db operation will perform in this thread
                   .subscribe(

                       {

                          Log.d(TAG, "User present in DB $it")
                       },
                       {

                           Log.d(TAG, "Error comes $it")
                       }
                   )

           )

     }

    /**
     *
     *  I don't write observedOn here because i don't care
     * to get the result in main thread because i am using
     * postvalue which will automatically send the data to
     * the main thread which i pass
     *
     * */


    fun getAllUsers(){

        compositeDisposable.add(
        databaseService.getUserDao()
            .getAllUsers()
            .subscribeOn(Schedulers.io())
            .subscribe(
                {

                    userList = it

                    Log.d(TAG, "Get All Users ${it.toString()}")
                    users.postValue(it)
                },
                {

                    Log.d(TAG, "Error occures ${it.toString()}")
                }
            )
        )

    }

    /**
     *  I don't write observedOn here because i don't care
     * to get the result in main thread because i am using
     * postvalue which will automatically send the data to
     * the main thread which i pass
     *
     */

    fun deleteUser(){

        if(userList.isNotEmpty())
        compositeDisposable.add(
            databaseService.getUserDao()
                .deleteUser(userList[0])
                .flatMap {
                    databaseService.getUserDao().getAllUsers()
                }
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {

                        userList = it
                        users.postValue(it)
                    },
                    {

                        Log.d(TAG, "Error occures ${it.toString()}")
                    }
                )
        )

    }


    fun onDestroy(){
        compositeDisposable.dispose()
    }

}
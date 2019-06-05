package com.demo.roomdatabase.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import com.demo.roomdatabase.MyApplication
import com.demo.roomdatabase.R
import com.demo.roomdatabase.di.components.DaggerActivityComponent
import com.demo.roomdatabase.di.modules.ActivityModule
import com.demo.roomdatabase.ui.home.HomeFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG = "MainActivity"
    }

    @Inject
    lateinit var viewModel: MainViewModel
    private lateinit var tvData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        tvData = findViewById(R.id.tvData)

        viewModel.users.observe(this, Observer {

            tvData.text = it.toString()
        })


        addHomeFragment()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getAllUsers()
    }

    override fun onStop() {
        super.onStop()
        viewModel.deleteUser()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    private fun getDependencies(){

        DaggerActivityComponent.builder()
            .applicationComponent((application as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)

        Log.d("DEBUG", viewModel.toString())

    }

    private fun addHomeFragment(){

        if(supportFragmentManager.findFragmentByTag(TAG) == null){

            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment,HomeFragment.getInstance(),HomeFragment.TAG)
                .commit()
        }
    }
}

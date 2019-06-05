package com.demo.roomdatabase.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.demo.roomdatabase.MyApplication
import com.demo.roomdatabase.R
import com.demo.roomdatabase.di.components.DaggerFragmentComponent
import com.demo.roomdatabase.di.modules.FragmentModule
import javax.inject.Inject

class HomeFragment : Fragment(){

    companion object{
        val TAG = "HomeFragment"
        fun getInstance(): HomeFragment{

            val arg = Bundle()
            val fragment= HomeFragment()
            fragment.arguments = arg
            return fragment
        }
    }

    @Inject
    lateinit var homeViewModel: HomeViewModel

    lateinit var tvData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvData = view.findViewById(R.id.tvData)

        tvData.text = homeViewModel.someData
    }

    fun getDependencies(){

        DaggerFragmentComponent.builder()
            .applicationComponent((context!!.applicationContext as MyApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()
            .inject(this)

        Log.d("DEBUG", homeViewModel.toString())
    }

}
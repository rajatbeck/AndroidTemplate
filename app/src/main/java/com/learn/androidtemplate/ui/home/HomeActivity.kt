package com.learn.androidtemplate.ui.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.learn.androidtemplate.R
import com.learn.androidtemplate.utils.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var homeActivityViewModel: HomeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeActivityViewModel::class.java)

        homeActivityViewModel.check()


    }
}

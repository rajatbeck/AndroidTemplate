package com.learn.androidtemplate.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.androidtemplate.R
import com.learn.androidtemplate.db.Feed
import com.learn.androidtemplate.utils.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var homeAdapter: HomeAdapter

    private lateinit var homeActivityViewModel: HomeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeActivityViewModel::class.java)

        rvList.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = homeAdapter
        }

        homeActivityViewModel.pagedFeedList.observe(this, Observer<PagedList<Feed>> {
            homeAdapter.submitList(it)
        })

        homeActivityViewModel.fetchFeed()


    }
}

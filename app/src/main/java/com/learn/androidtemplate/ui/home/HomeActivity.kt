package com.learn.androidtemplate.ui.home

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.androidtemplate.R
import com.learn.androidtemplate.db.Feed
import com.learn.androidtemplate.ui.NetworkState
import com.learn.androidtemplate.utils.DividerItemDecoration
import com.learn.androidtemplate.utils.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var homeAdapter: HomeAdapter

    private lateinit var model: HomeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ViewModelProviders.of(this, viewModelFactory).get(HomeActivityViewModel::class.java)
        homeAdapter = HomeAdapter {
            model.retry()
        }
        rvList.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            addItemDecoration(DividerItemDecoration(ContextCompat.getDrawable(this@HomeActivity,R.drawable.line_divider)))
            adapter = homeAdapter
        }

        model.pagedFeedList.observe(this, Observer<PagedList<Feed>> {
            homeAdapter.submitList(it)
        })

        model.networkState.observe(this, Observer<NetworkState> {
            homeAdapter.setNetworkState(it)
        })

        model.fetchFeed()


    }
}

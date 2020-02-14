package com.mjpecora.app.challenge.ui

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mjpecora.app.challenge.R
import com.mjpecora.app.challenge.adapters.VenueAdapter
import com.mjpecora.app.challenge.databinding.ActivityMainBinding
import com.mjpecora.app.challenge.networking.ApiFactory
import com.mjpecora.app.challenge.viewmodels.VenueViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: VenueViewModel
    private lateinit var binding: ActivityMainBinding

    private val venueAdapter by lazy {
        VenueAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding
        viewModel = VenueViewModel(ApiFactory.api)
    }

    override fun onStart() {
        super.onStart()
        binding.cityVenueRv?.run {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = venueAdapter
            addItemDecoration(object: RecyclerView.ItemDecoration() {
                override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                    with (outRect) {
                        if (parent.getChildAdapterPosition(view) % 2 == 0)
                            this.left = resources.getDimensionPixelSize(R.dimen.card_left_right_margin)
                        this.right = resources.getDimensionPixelSize(R.dimen.card_left_right_margin)
                        if (parent.getChildAdapterPosition(view) == 0)
                            this.top =resources.getDimensionPixelSize(R.dimen.card_left_right_margin)
                        this.bottom = resources.getDimensionPixelSize(R.dimen.card_left_right_margin)
                    }
                }
            })
        }
        binding.executePendingBindings()
        viewModel.getList()
        initGuideObserver()
    }

    private fun initGuideObserver() {
        viewModel.list.observe(this, Observer {
            binding.loadingView.gone()
            it.data.let(venueAdapter::submitList)
        })
    }

    private fun View.gone() {
        this.visibility = View.GONE
    }
}

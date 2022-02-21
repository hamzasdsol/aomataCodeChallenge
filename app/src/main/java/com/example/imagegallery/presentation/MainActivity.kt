package com.example.imagegallery.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.example.imagegallery.R
import com.example.imagegallery.data.model.ImagesList
import com.example.imagegallery.databinding.ActivityMainBinding
import com.example.imagegallery.util.Resource
import com.example.imagegallery.util.showToast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: ImagesViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var imagesAdapter: ImagesAdapter
    private var imagesList: MutableList<ImagesList.ImagesListItem> = mutableListOf()

    val pageNo = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDataBinding()
        setupAdapter()
        binding.rvMovies.apply {
            adapter = imagesAdapter
        }

        viewModel.imagesResponse.observe(this, Observer { resource ->
            when (resource) {
                is Resource.Loading -> binding.pbLoading.visibility = View.VISIBLE
                is Resource.Error -> {
                    showToast(resource.error)
                    binding.pbLoading.visibility = View.GONE
                }
                is Resource.Success -> {
                    binding.pbLoading.visibility = View.GONE
                    setupList(resource.data!!)
                    imagesAdapter.updateData(imagesList)

                }
            }
        })


        viewModel.getMovies(pageNo)

    }

    private fun setupList(list: List<ImagesList.ImagesListItem>) {
        if (pageNo == 1 && imagesList.isNotEmpty()) {
            imagesList.clear()
        }
        imagesList.addAll(list)
    }


    private fun setupDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
    private fun setupAdapter() {
        imagesAdapter = ImagesAdapter {
           /* Intent(this, MovieDetailActivity::class.java).apply {
                putExtra(Constants.ID, it!!)
                startActivity(this)
            }*/
        }
        val layoutManager =binding.rvMovies.layoutManager as GridLayoutManager

        layoutManager?.spanCount=10
        layoutManager.requestLayout()
    }
}
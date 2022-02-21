package com.example.imagegallery.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.imagegallery.R
import com.example.imagegallery.data.model.ImagesList
import com.example.imagegallery.databinding.ImagesListItemBinding
import com.example.imagegallery.util.DiffUtilCallBack

class ImagesAdapter(private val callback: (Int?) -> Unit) :
    RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {
    var imagesList: List<ImagesList.ImagesListItem> = mutableListOf()

    class ViewHolder(val binding: ImagesListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.images_list_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = imagesList[position]
        holder.binding.apply {
            result = dataItem
            this.root.setOnClickListener {
                // callback.invoke(dataItem.id)
            }
        }
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    fun updateData(data: List<ImagesList.ImagesListItem>) {
        val diffCallback = DiffUtilCallBack(this.imagesList, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)
        this.imagesList = data
    }
}
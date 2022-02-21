package com.example.imagegallery.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("android:srcImage")
    fun setImageSrc(imageView: ImageView, url: String?) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(FitCenter(), RoundedCorners(8))
        Glide.with(imageView.context).load(url).apply(requestOptions).into(imageView)
    }



package com.example.imagegallery.domain.repository

import com.example.imagegallery.data.model.ImagesList
import retrofit2.Response
import retrofit2.http.Query

abstract class ImagesRepository {
    abstract suspend fun getPhotos(page: Int):Response<ImagesList>
}
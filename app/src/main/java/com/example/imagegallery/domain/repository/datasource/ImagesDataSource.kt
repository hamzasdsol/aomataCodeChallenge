package com.example.imagegallery.domain.repository.datasource

import com.example.imagegallery.data.model.ImagesList
import retrofit2.Response

interface ImagesDataSource {
     suspend fun getPhotos(page: Int): Response<ImagesList>
}
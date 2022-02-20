package com.example.imagegallery.data.repository

import com.example.imagegallery.data.model.ImagesList
import com.example.imagegallery.domain.repository.ImagesRepository
import com.example.imagegallery.domain.repository.datasource.ImagesDataSource
import retrofit2.Response

class ImagesRepostoryImpl(private val imagesDataSource: ImagesDataSource) : ImagesRepository() {
    override suspend fun getPhotos(page: Int): Response<ImagesList> =
        imagesDataSource.getPhotos(page)
}
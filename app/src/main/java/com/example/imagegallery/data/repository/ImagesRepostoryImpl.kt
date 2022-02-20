package com.example.imagegallery.data.repository

import com.example.imagegallery.data.model.ImagesList
import com.example.imagegallery.domain.repository.ImagesRepository
import retrofit2.Response

class ImagesRepostoryImpl: ImagesRepository() {
    override suspend fun getPhotos(page: Int): Response<ImagesList> {
        TODO("Not yet implemented")
    }
}
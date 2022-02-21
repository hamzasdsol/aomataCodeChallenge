package com.example.imagegallery.domain.repository.datasourceimpl

import com.example.imagegallery.data.api.ImageService
import com.example.imagegallery.data.model.ImagesList
import com.example.imagegallery.domain.repository.datasource.ImagesDataSource
import retrofit2.Response
import javax.inject.Inject

class ImagesDataSourceImpl(val apiService: ImageService) : ImagesDataSource {
    override suspend fun getPhotos(page: Int) = apiService.getPhotos(page)
}
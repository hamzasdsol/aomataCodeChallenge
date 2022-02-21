package com.example.imagegallery.domain.usecase

import com.example.imagegallery.data.model.ImagesList
import com.example.imagegallery.domain.repository.ImagesRepository
import retrofit2.Response
import javax.inject.Inject

class GetImagesUseCase(private val repository: ImagesRepository) {
    suspend fun execute(pageNo: Int): Response<ImagesList> = repository.getPhotos(pageNo)
}
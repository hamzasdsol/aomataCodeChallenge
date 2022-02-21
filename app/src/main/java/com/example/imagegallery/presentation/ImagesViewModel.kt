package com.example.imagegallery.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.HttpException
import com.example.imagegallery.R
import com.example.imagegallery.data.model.ImagesList
import com.example.imagegallery.domain.usecase.GetImagesUseCase
import com.example.imagegallery.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(
    private val imagesUseCase: GetImagesUseCase
) : ViewModel() {
    private val _getimagesResponse: MutableLiveData<Resource<ImagesList>> = MutableLiveData()
    val imagesResponse: LiveData<Resource<ImagesList>>
        get() = _getimagesResponse


    fun getMovies(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _getimagesResponse.postValue(Resource.Loading())

            try {
                val response = imagesUseCase.execute(page)
                if (response?.isSuccessful) {
                    _getimagesResponse.postValue(Resource.Success(response?.body()))
                } else {
                    _getimagesResponse.postValue(Resource.Error(response?.message()))
                }
            } catch (e: Exception) {
                _getimagesResponse.postValue(Resource.Error(e.localizedMessage))
            }

        }
    }



}
package com.example.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.example.presentation.BaseViewModel

class ImagesPagerViewModel: BaseViewModel<ImagesPagerStates, ImagesPagerTransition>()  {
    //private val repository = Repository()
    //private val getImagesRepository = GetImages(repository)

    private val stateImage: MutableLiveData<List<Int>> = MutableLiveData()
    val _stateImages: LiveData<List<Int>>
        get() = stateImage

    fun getImages() {
        //stateImage.value = getImageRepository()
    }
}
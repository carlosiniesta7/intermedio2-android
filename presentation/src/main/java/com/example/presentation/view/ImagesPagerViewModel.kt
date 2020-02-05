package com.example.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain2.GetImages
import com.example.presentation.R
import es.example.presentation.BaseViewModel

class ImagesPagerViewModel(val getImages: GetImages): BaseViewModel<ImagesPagerStates, ImagesPagerTransition>()  {
    //private val repository = Repository()
    //private val getImagesRepository = GetImages(repository)

    private val stateImage: MutableLiveData<List<Int>> = MutableLiveData()
    val _stateImages: LiveData<List<Int>>
        get() = stateImage

    fun getImages() {
        //stateImage.value = getImages.invoke()
        stateImage.value = listOf(R.drawable.ic_producto_subido, R.drawable.ic_launcher_background, R.drawable.my_button_background)
    }
}
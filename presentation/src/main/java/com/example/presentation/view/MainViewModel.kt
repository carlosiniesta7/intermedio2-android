package com.example.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain2.AddElement
import com.example.domain2.GetElement
import com.example.domain2.model.Element

class MainViewModel(val getElement: GetElement, val addElement: AddElement) : ViewModel() {

    val stateTitle = liveData {
        emit("Elements")
    }

    private val _stateList: MutableLiveData<List<Element>> = MutableLiveData()
    val stateList: LiveData<List<Element>>
        get() = _stateList

    fun getElements() {
        _stateList.value = getElement.invoke()
    }

    fun addElement() {
        _stateList.value = addElement.invoke()
    }
}
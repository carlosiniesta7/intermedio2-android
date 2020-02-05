package com.example.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain2.AddElement
import com.example.domain2.GetElements
import com.example.domain2.model.Element

class MainViewModel(val getElement: GetElements, val addElement: AddElement) : ViewModel() {

}
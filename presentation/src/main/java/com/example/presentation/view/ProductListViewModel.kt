package com.example.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain2.GetElements
import com.example.domain2.model.Element
import es.example.presentation.BaseViewModel
import kotlinx.coroutines.launch

class ProductListViewModel(val getElements: GetElements) : BaseViewModel<ProductListStates, ProductListTransition>() {

    private val _stateList: MutableLiveData<List<Element>> = MutableLiveData()

    val stateList: LiveData<List<Element>>
        get() = _stateList

    fun getElements() {

        viewModelScope.launch {
            var response = getElements.invoke()

            _stateList.value = response
        }
    }
}
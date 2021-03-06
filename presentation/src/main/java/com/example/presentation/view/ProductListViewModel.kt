package com.example.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain2.GetElements
import com.example.domain2.model.Element
import com.example.presentation.view.viewEntities.ElementViewEntity
import es.example.presentation.BaseViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ProductListViewModel(val getElements: GetElements) : BaseViewModel<ProductListStates, ProductListTransition>() {

    private val _stateList: MutableLiveData<List<Element>> = MutableLiveData()

    fun getElements() {

        viewModelScope.launch {

            val response = viewModelScope.async {
                getElements.invoke()
            }

            response.await().fold(::handleProductListError, ::handleProductListOk)
        }
    }

    fun handleProductListOk(response: List<Element>){
        var list: MutableList<ElementViewEntity> = mutableListOf()

        response.forEach {
            list.add(ElementViewEntity(it.name, it.description))
        }

        viewState.value = ProductListStates.InitListState(list)
    }

    fun handleProductListError(e: Exception){

    }

    fun goToDetail(name: String, description: String){
        viewTransition.value = ProductListTransition.GoToProductDetail(name, description)
    }
}
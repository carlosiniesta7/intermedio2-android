package com.example.presentation.view

import androidx.lifecycle.viewModelScope
import com.example.domain2.DeleteElement
import com.example.domain2.model.Element
import es.example.presentation.BaseViewModel
import fold
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val deleteElement: DeleteElement): BaseViewModel<ProductDetailStates, ProductDetailTransition>()  {


    fun deleteElement(element : Element) {
        viewModelScope.launch {
            val fakeResponse = viewModelScope.async {
                deleteElement.execute(element)
            }

            fakeResponse.await().fold(::handleDeleteElementError, ::handleDeletelementSuccess)
        }
    }

    private fun handleDeleteElementError(it: Exception)
    {
        viewTransition.value = ProductDetailTransition.DeleteElementKO()
    }

    private fun handleDeletelementSuccess(it: Element)
    {
        viewTransition.value = ProductDetailTransition.DeleteElementOK(
            Element(it.name, it.description)
        )
    }
}
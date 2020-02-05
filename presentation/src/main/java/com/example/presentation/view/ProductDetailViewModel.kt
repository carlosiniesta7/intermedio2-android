package com.example.presentation.view

import androidx.lifecycle.viewModelScope
import com.example.domain2.DeleteElement
import es.example.presentation.BaseViewModel
import fold
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val deleteElement: DeleteElement): BaseViewModel<ProductDetailStates, ProductDetailTransition>()  {


    fun deleteElement(name : String) {
        viewModelScope.launch {
            val fakeResponse = viewModelScope.async {
                var response = deleteElement.execute(name)
                response?.fold(::handleDeleteElementError, ::handleDeletelementSuccess)
            }
        }
    }

    private fun handleDeleteElementError(it: Exception)
    {
        viewTransition.value = ProductDetailTransition.DeleteElementKO()
    }

    private fun handleDeletelementSuccess(it: Boolean)
    {
        viewTransition.value = ProductDetailTransition.DeleteElementOK(
            ""
        )
    }
}
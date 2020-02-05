package com.example.presentation.view

import es.example.presentation.BaseViewModel

class ProductDetailViewModel: BaseViewModel<ProductDetailStates, ProductDetailTransition>()  {
    fun goToViewPager(){
        viewTransition.value = ProductDetailTransition.NavigateToImagePager()
    }
}
package com.example.presentation.view

import com.example.presentation.R
import es.example.presentation.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailFragment: BaseFragment<ProductDetailStates, ProductDetailTransition>(){

    override val viewModel by viewModel<ProductDetailViewModel>()
    override fun initViews() {
    }

    override fun manageState(state: ProductDetailStates) {
    }

    override fun manageTransition(transition: ProductDetailTransition) {
    }

    override fun initListeners() {
    }

    override fun getLayout(): Int {
        return R.layout.product_detail_fragment
    }
}
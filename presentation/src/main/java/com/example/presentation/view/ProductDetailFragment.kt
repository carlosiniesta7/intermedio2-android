package com.example.presentation.view

import android.widget.Toast
import com.example.domain2.model.Element
import com.example.presentation.R
import com.example.presentation.view.viewEntities.ElementViewEntity
import es.example.presentation.BaseFragment
import kotlinx.android.synthetic.main.product_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailFragment: BaseFragment<ProductDetailStates, ProductDetailTransition>(){

    private var myElement : String? = ""

    override val viewModel by viewModel<ProductDetailViewModel>()
    override fun initViews() {

        arguments?.let {
            tvTitleDetail.text = it.getString("productName")
            myElement = it.getString("productName")
        }
    }

    override fun manageState(state: ProductDetailStates) {
        when(state)
        {
            is ProductDetailStates.DeleteProductViewState -> {
                deleteProduct(state.element)
            }

        }
    }

    override fun manageTransition(transition: ProductDetailTransition) {
    }

    override fun initListeners() {

        btBorrar.setOnClickListener {
            myElement?.let { element -> deleteProduct(element) }
        }
    }

    fun deleteProduct(element : String)
    {
        viewModel.deleteElement(element)
    }

    override fun getLayout(): Int {
        return R.layout.product_detail_fragment
    }
}
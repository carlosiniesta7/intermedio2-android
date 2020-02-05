package com.example.presentation.view

import android.widget.Toast
import com.example.domain2.model.Element
import com.example.presentation.R
import es.example.presentation.BaseFragment
import kotlinx.android.synthetic.main.product_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailFragment: BaseFragment<ProductDetailStates, ProductDetailTransition>(){

    private lateinit var myElement : Element

    override val viewModel by viewModel<ProductDetailViewModel>()
    override fun initViews() {

        myElement = Element(
            "",
            ""
        )
    }

    override fun manageState(state: ProductDetailStates) {
        when(state)
        {
            is ProductDetailStates.DeleteProductViewState -> {
                deleteProduct(state.elementViewEntity)
            }
            else ->
            {
                Toast.makeText(context, "Ha ocurrido un error al borrar el producto", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun manageTransition(transition: ProductDetailTransition) {
    }

    override fun initListeners() {

        btBorrar.setOnClickListener {
            deleteProduct(myElement)
        }
    }

    fun deleteProduct(element : Element)
    {
        viewModel.deleteElement(element)
    }

    override fun getLayout(): Int {
        return R.layout.product_detail_fragment
    }
}
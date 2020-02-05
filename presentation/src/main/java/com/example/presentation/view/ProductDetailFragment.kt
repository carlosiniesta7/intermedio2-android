package com.example.presentation.view

import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import es.example.presentation.BaseFragment
import kotlinx.android.synthetic.main.product_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailFragment: BaseFragment<ProductDetailStates, ProductDetailTransition>(){

    override val viewModel by viewModel<ProductDetailViewModel>()
    override fun initViews() {
        arguments?.let {
            tvTitleDetail.text = it.getString("productName")
        }
    }

    override fun manageState(state: ProductDetailStates) {
    }

    override fun manageTransition(transition: ProductDetailTransition) {
        when(transition){
            is ProductDetailTransition.NavigateToImagePager ->
                findNavController().navigate(R.id.action_product_detail_fragment_to_image_pager_fragment)
        }
    }

    override fun initListeners() {
        rlProductAuxContent.setOnClickListener {
            viewModel.goToViewPager()
        }
    }

    override fun getLayout(): Int {
        return R.layout.product_detail_fragment
    }
}
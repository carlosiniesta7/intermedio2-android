package com.example.presentation.view

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import es.example.presentation.BaseFragment
import kotlinx.android.synthetic.main.product_list_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductListFragment: BaseFragment<ProductListStates, ProductListTransition>(){

    var adapter: MainAdapter? = null

    override val viewModel by viewModel<ProductListViewModel>()

    override fun initViews() {
        adapter = MainAdapter()

        rvElements?.adapter = adapter

        viewModel.stateList.observe(this, Observer {
            it?.let { elements ->
                adapter?.submitList(elements)
                adapter?.notifyDataSetChanged()
            }
        })

        viewModel.getElements()

       bAddElement?.setOnClickListener {
           findNavController().navigate(R.id.action_product_list_fragment_to_product_detail_fragment)
        }
    }

    override fun manageState(state: ProductListStates) {
    }

    override fun manageTransition(transition: ProductListTransition) {
    }

    override fun initListeners() {
    }

    override fun getLayout(): Int {
        return R.layout.product_list_layout
    }
}
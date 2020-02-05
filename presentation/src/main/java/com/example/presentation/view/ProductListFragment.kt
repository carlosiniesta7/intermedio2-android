package com.example.presentation.view

import androidx.lifecycle.Observer
import com.example.presentation.R
import es.example.presentation.BaseFragment
import es.example.presentation.BaseViewModel
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

//        bAddElement?.setOnClickListener {
//            MyViewModel.addElement()
//        }
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
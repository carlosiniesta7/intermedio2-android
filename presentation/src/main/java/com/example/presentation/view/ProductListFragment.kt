package com.example.presentation.view

import androidx.lifecycle.Observer
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun manageTransition(transition: ProductListTransition) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayout(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
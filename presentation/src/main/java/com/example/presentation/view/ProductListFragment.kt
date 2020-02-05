package com.example.presentation.view

import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.view.viewEntities.ElementViewEntity
import es.example.presentation.BaseFragment
import kotlinx.android.synthetic.main.product_list_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductListFragment: BaseFragment<ProductListStates, ProductListTransition>(),
    MainAdapter.OnItemClickListener {


    var adapter: MainAdapter? = null

    override val viewModel by viewModel<ProductListViewModel>()

    override fun initViews() {
        adapter = MainAdapter(this)

        rvElements?.adapter = adapter

//        viewModel.stateList.observe(this, Observer {
//            it?.let { elements ->
//                adapter?.submitList(elements)
//                adapter?.notifyDataSetChanged()
//            }
//        })

        viewModel.getElements()

    }

    override fun manageState(state: ProductListStates) {
        when(state){
            is ProductListStates.InitListState->{
                adapter?.submitList(state.elementList.toList())
                adapter?.notifyDataSetChanged()
            }
        }
    }

    override fun manageTransition(transition: ProductListTransition) {

        when(transition) {
            is ProductListTransition.GoToProductDetail -> {
                val direction = ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(transition.name, transition.description)
                val action = findNavController().currentDestination?.getAction(R.id.action_product_list_fragment_to_product_detail_fragment)
                if (action != null) findNavController().navigate(direction)
            }
        }
    }

    override fun initListeners() {
    }

    override fun getLayout(): Int {
        return R.layout.product_list_layout
    }

    override fun onItemClick(name: String, description: String) {
        viewModel.goToDetail(name, description)
    }

}
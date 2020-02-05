package com.example.presentation.view

import androidx.lifecycle.Observer
import com.example.presentation.R
import es.example.presentation.BaseFragment
import es.example.presentation.BaseViewModel
import kotlinx.android.synthetic.main.product_list_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment: BaseFragment<LoginState, LoginTransition>(){

    var adapter: MainAdapter? = null

    override val viewModel by viewModel<LoginViewModel>()

    override fun initViews() {

    }

    override fun manageState(state: LoginState) {
    }

    override fun manageTransition(transition: LoginTransition) {
    }

    override fun initListeners() {
    }

    override fun getLayout(): Int {
        return R.layout.fragment_login
    }
}
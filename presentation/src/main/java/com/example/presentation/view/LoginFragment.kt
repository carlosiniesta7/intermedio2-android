package com.example.presentation.view

import androidx.navigation.fragment.findNavController
import androidx.lifecycle.Observer
import com.example.presentation.R
import es.example.presentation.BaseFragment
import es.example.presentation.BaseViewModel
import kotlinx.android.synthetic.main.product_list_layout.*
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment: BaseFragment<LoginState, LoginTransition>(){


    override val viewModel by viewModel <LoginViewModel>()

    override fun initViews() {
    }

    override fun manageState(state: LoginState) {
    }

    override fun manageTransition(transition: LoginTransition) {
    }

    override fun initListeners() {
        btn_login.setOnClickListener {
            //TODO: UC-Login
            //viewModel.doLogin()
            findNavController().navigate(R.id.action_login_fragment_to_product_list_fragment)
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_login
    }
}
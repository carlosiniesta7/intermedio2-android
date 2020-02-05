package com.example.presentation.view

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import es.example.presentation.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment: BaseFragment<LoginState, LoginTransition>(){

    override val viewModel by viewModel <LoginViewModel>()

    override fun initViews() {
    }

    override fun manageState(state: LoginState) {
        when(state){
            is LoginState.NotReadyToSignIn ->
                Toast.makeText(context, getString(R.string.NotReadySignIn), Toast.LENGTH_SHORT).show()
            is LoginState.SignInError ->
                Toast.makeText(context, getString(R.string.SignInError), Toast.LENGTH_SHORT).show()
        }
    }

    override fun manageTransition(transition: LoginTransition) {
        when(transition){
            is LoginTransition.NavigateToProductList ->
                findNavController().navigate(R.id.action_login_fragment_to_product_list_fragment)
        }
    }

    override fun initListeners() {
        btn_login.setOnClickListener {
            viewModel.doLogin(et_username.text.toString(), et_password.text.toString())
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_login
    }
}
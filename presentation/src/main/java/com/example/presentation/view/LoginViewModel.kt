package com.example.presentation.view

import androidx.lifecycle.viewModelScope
import com.example.domain2.DoLogin
import es.example.presentation.BaseViewModel
import kotlinx.coroutines.launch

class LoginViewModel(val doLogin: DoLogin): BaseViewModel<LoginState, LoginTransition>() {

    fun doLogin(name: String?, password: String?) {
        if(name.isNullOrEmpty() || password.isNullOrEmpty()) {
            viewState.value = LoginState.NotReadyToSignIn
        } else {

            viewModelScope.launch {
                var response = doLogin.invoke()
                if (response){
                    viewState.value = LoginState.SignInOk
                    viewTransition.value = LoginTransition.NavigateToProductList()
                } else {
                    viewState.value = LoginState.SignInError
                    viewTransition.value = LoginTransition.NotNavigate()
                }
            }
        }
    }
}
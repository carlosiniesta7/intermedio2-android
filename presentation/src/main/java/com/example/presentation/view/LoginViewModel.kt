package com.example.presentation.view

import androidx.lifecycle.viewModelScope
import com.example.domain2.DoLogin
import es.example.presentation.BaseViewModel
import kotlinx.coroutines.launch

class LoginViewModel(val doLogin: DoLogin): BaseViewModel<LoginState, LoginTransition>() {

    fun doLogin() {
        viewModelScope.launch {
            var response = doLogin.invoke()
            if (response)
                viewTransition.value = LoginTransition.NavigateToProductList()
            else viewTransition.value = LoginTransition.NotNavigate()
        }
    }
}
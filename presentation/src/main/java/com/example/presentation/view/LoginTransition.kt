package com.example.presentation.view

sealed class LoginTransition {
    class NavigateToProductList: LoginTransition()
    class NotNavigate: LoginTransition()
}
package com.example.presentation.view

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class LoginState: Parcelable {
    @Parcelize
    object SignInOk : LoginState()

    @Parcelize
    object SignInError : LoginState()

    @Parcelize
    object NotReadyToSignIn : LoginState()
}
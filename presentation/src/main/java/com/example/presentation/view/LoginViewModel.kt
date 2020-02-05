package com.example.presentation.view

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain2.GetElements
import com.example.domain2.model.Element
import es.example.presentation.BaseViewModel

class LoginViewModel(val getElement: GetElements): BaseViewModel<LoginState, LoginTransition>() {


    fun doLogin() {
        //UC-Login
    }
}
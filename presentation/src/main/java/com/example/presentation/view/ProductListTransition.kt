package com.example.presentation.view

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class ProductListTransition: Parcelable {

    @Parcelize
    class GoToProductDetail(var name: String, var description: String): ProductListTransition()
}
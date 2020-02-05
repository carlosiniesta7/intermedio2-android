package com.example.presentation.view

import android.os.Parcelable
import com.example.domain2.model.Element
import com.example.presentation.view.viewEntities.ElementViewEntity
import kotlinx.android.parcel.Parcelize

sealed class ProductDetailStates: Parcelable {
    @Parcelize
    class DeleteProductViewState(val element: String) : ProductDetailStates()

}
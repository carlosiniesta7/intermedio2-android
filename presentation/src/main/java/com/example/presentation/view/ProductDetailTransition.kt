package com.example.presentation.view

import android.os.Parcelable
import com.example.domain2.model.Element
import com.example.presentation.view.viewEntities.ElementViewEntity
import kotlinx.android.parcel.Parcelize

sealed class ProductDetailTransition : Parcelable {

    @Parcelize
    class DeleteElementOK(val elementName: String) : ProductDetailTransition()

    @Parcelize
    class DeleteElementKO: ProductDetailTransition()
}
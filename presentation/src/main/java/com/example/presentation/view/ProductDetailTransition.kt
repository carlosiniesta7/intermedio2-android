package com.example.presentation.view

import android.os.Parcelable
import com.example.domain2.model.Element
import kotlinx.android.parcel.Parcelize

sealed class ProductDetailTransition : Parcelable {

    @Parcelize
    class DeleteElementOK(val element: Element) : ProductDetailTransition()

    @Parcelize
    class DeleteElementKO: ProductDetailTransition()
}
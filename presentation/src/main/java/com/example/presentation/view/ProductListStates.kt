package com.example.presentation.view

import android.os.Parcelable
import com.example.presentation.view.viewEntities.ElementViewEntity
import kotlinx.android.parcel.Parcelize

sealed class ProductListStates: Parcelable {

    @Parcelize
    class InitListState(var elementList: List<ElementViewEntity>) : ProductListStates()
}
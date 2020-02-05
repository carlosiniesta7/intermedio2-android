package com.example.presentation.view.viewEntities

import android.os.Parcel
import android.os.Parcelable
import com.example.domain2.model.Element
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ElementViewEntity(var name: String = "",
                             var description: String = "") : Parcelable{

    constructor(element: Element) : this() {
        name = element.name
        description = element.description
    }
}
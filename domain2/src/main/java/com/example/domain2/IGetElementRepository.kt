package com.example.domain2

import com.example.domain2.model.Element

interface IGetElementRepository {

    fun getElements(): List<Element>
    fun addElement(): List<Element>
}
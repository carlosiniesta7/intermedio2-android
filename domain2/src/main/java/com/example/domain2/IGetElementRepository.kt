package com.example.domain2

import Either
import com.example.domain2.model.Element

interface IGetElementRepository {

    fun getElements(): List<Element>
    fun getElement(name: String): Element
    fun addElement(): List<Element>
    //fun deleteElement(name: String): Boolean
    suspend fun deleteElement(name: String): Either<Exception, Boolean>
    fun doLogin(): Boolean
    fun getImages(): List<Int>
}
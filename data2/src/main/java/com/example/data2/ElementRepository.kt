package com.example.data2

import com.example.domain2.model.Element


object ElementRepository {

    var elementList: MutableList<Element> = mutableListOf()

    fun getElements(): MutableList<Element> {
        elementList.clear()

        (0 until 50).map {
            elementList.add(Element(name = "Element $it"))
        }

        return elementList
    }

    fun addElement(): List<Element> {
        elementList.clear()

        (0 until 50).map {
            if (it in 6..9) {
                elementList.add(Element(name = "Hi $it"))
            } else {
                elementList.add(Element(name = "Element $it"))
            }
        }

        return elementList
    }
}
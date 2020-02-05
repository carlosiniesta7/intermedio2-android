package com.example.data2

import com.example.domain2.model.Element

const val description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."

object ElementRepository {

    var elementList: MutableList<Element> = mutableListOf()

    fun getElements(): MutableList<Element> {
        elementList.clear()

        (0 until 50).map {
            elementList.add(Element(name = "Título $it", description = description))
        }

        return elementList
    }

    fun addElement(): List<Element> {
        elementList.clear()

        (0 until 50).map {
            if (it in 6..9) {
                elementList.add(Element(name = "Hi $it", description = description))
            } else {
                elementList.add(Element(name = "Element $it", description = description))
            }
        }

        return elementList
    }
}
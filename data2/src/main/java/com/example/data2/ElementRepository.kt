package com.example.data2

import com.example.domain2.model.Element

const val description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."

object ElementRepository {

    var elementList: MutableList<Element> = initElements()


    fun initElements(): MutableList<Element> {
        var list: MutableList<Element> = mutableListOf()

        (0 until 50).map {
            list.add(Element(name = "Título $it", description = description))
        }

        return list
    }

    fun getElements(): MutableList<Element> {
        return elementList
    }

    fun getElement(name: String): Element{

        elementList.forEach {element ->
            if(element.name == name)
                return element
        }

        return Element("empty","empty")
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

    fun deleteElement(name: String): Boolean{

        var elementToRemove: Element? = null

        elementList.forEach {element ->
            if(element.name == name)
                elementToRemove = element
        }

        return elementList.remove(elementToRemove)
    }
}
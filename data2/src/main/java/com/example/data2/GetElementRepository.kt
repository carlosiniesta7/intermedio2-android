package com.example.data2

import com.example.domain2.IGetElementRepository
import com.example.domain2.model.Element

class GetElementRepository: IGetElementRepository {
    override fun getElement(name: String): Element {
        return ElementRepository.getElement(name)
    }

    override fun deleteElement(name: String): Boolean {
        return ElementRepository.deleteElement(name)
    }

    override fun getElements(): List<Element> {
        return ElementRepository.getElements()
    }

    override fun addElement(): List<Element> {
        return ElementRepository.addElement()
    }
}
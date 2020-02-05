package com.example.data2

import com.example.domain2.IGetElementRepository
import com.example.domain2.model.Element

class GetElementRepository: IGetElementRepository {
    override fun getElements(): List<Element> {
        return ElementRepository.getElements()
    }

    override fun addElement(): List<Element> {
        return ElementRepository.addElement()
    }
}
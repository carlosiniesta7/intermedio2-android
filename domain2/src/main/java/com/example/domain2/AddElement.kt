package com.example.domain2

import com.example.domain2.model.Element

class AddElement(private val repository: IGetElementRepository) {
    operator fun invoke(): List<Element> = repository.addElement()
}
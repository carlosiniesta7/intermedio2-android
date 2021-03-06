package com.example.domain2

import com.example.domain2.model.Element

class GetElement (private val repository: IGetElementRepository) {
    operator fun invoke(name: String): Element = repository.getElement(name)
}
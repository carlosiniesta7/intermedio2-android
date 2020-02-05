package com.example.domain2

import com.example.domain2.model.Element
import com.sun.org.apache.xpath.internal.operations.Bool

class DeleteElement(private val repository: IGetElementRepository) {
    operator fun invoke(name: String): Boolean = repository.deleteElement(name)
}
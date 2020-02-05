package com.example.data2

import Either
import com.example.domain2.IGetElementRepository
import com.example.domain2.model.Element

class GetElementRepository: IGetElementRepository {
    override suspend fun deleteElement(name: String): Either<Exception, Boolean> {
        return Either.Success(ElementRepository.deleteElement(name))
    }

    override fun getElement(name: String): Element {
        return ElementRepository.getElement(name)
    }



    override fun getElements(): List<Element> {
        return ElementRepository.getElements()
    }

    override fun addElement(): List<Element> {
        return ElementRepository.addElement()
    }

    override fun doLogin(): Boolean {
        return ElementRepository.doLogin()
    }

    override fun getImages(): List<Int> {
        return ElementRepository.getImages()
    }
}
package com.example.domain2

import Either
import UseCaseParamsExecutor
import com.example.domain2.model.Element

class DeleteElement(private val repository: IGetElementRepository) :
    UseCaseParamsExecutor<Exception, Element, Element> {
    override suspend fun execute(params: Element): Either<Exception, Element> {
        return when (val response = repository.deleteElement(params.name)) {
            is Either.Success -> Either.Success(response.value)
            is Either.Failure -> response
        }
    }
}


//operator fun invoke(element: Element): Boolean = repository.deleteElement(element.name)



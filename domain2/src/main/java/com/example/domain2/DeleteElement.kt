package com.example.domain2

import Either
import UseCaseParamsExecutor

class DeleteElement(private val repository: IGetElementRepository) :
    UseCaseParamsExecutor<Exception, Boolean, String> {
    override suspend fun execute(params: String): Either<Exception, Boolean> {
        return when (val response = repository.deleteElement(params)) {
            is Either.Success -> Either.Success(true)
            is Either.Failure -> response
        }
    }
}


//operator fun invoke(element: Element): Boolean = repository.deleteElement(element.name)



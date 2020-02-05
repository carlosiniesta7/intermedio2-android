package com.example.domain2

import com.example.domain2.model.Element

class GetElements(private val repository: IGetElementRepository) {
     suspend fun invoke(): Either<Exception, List<Element>>{
         return Either.Right(repository.getElements())
    }
}
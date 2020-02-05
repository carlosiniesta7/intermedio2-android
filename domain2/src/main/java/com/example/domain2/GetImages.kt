package com.example.domain2

class GetImages( private val repository: IGetElementRepository) {
    operator fun invoke(): List<Int> = repository.getImages()
}
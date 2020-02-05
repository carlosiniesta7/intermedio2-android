package com.example.domain2

class DoLogin(private val repository: IGetElementRepository) {
    operator fun invoke(): Boolean = repository.doLogin()
}
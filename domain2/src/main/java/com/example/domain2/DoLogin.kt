package com.example.domain2

import com.example.domain2.model.Element

class DoLogin(private val repository: IGetElementRepository) {
    operator fun invoke(): Boolean = repository.doLogin()
}
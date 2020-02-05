package com.example.domain2

sealed class Either<out A, out B> {
    class Left<A>(val value: A): Either<A, Nothing>()
    class Right<B>(val value: B): Either<Nothing, B>()

    fun <T> fold(fnL: (A) -> T, fnR: (B) -> T): T {
        return when (this) {
            is Left -> fnL(value)
            is Right -> fnR(value)
        }
    }
}
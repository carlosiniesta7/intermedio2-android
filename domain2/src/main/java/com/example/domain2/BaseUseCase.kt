/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This abstraction represents an execution unit for different use cases (this means than any use
 * case in the application should implement this contract).
 *
 * By convention each UseCase implementation will execute its job in a background thread
 * (kotlin coroutine) and will post the result in the UI thread.
 */

interface UseCaseExecutor<F,S> {
    suspend fun execute () : Either<F, S>
}

interface UseCaseParamsExecutor<F, S, in Params> where Params : Any {
    suspend fun execute (params: Params) : Either<F, S>
}

interface UseCaseEmptyParamsExecutor<F, S> {
    suspend fun execute () : Either<F, S>
}


sealed class Either<out F, out S> {
    data class Failure<out F>(val error: F) : Either<F, Nothing>()
    data class Success<out S>(val value: S) : Either<Nothing, S>()
}

fun <F, S, A> Either<F, S>.fold(e: (F) -> A, s: (S) -> A) : A = when (this){
    is Either.Failure -> e(this.error)
    is Either.Success -> s(this.value)
}
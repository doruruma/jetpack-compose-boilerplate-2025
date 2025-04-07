package id.andra.jetpackcomposeboilerplate.utils.network

sealed class Resource<T>(
    val data: T? = null,
    val error: Throwable? = null,
    val code: Int? = null
) {
    class Success<T>(data: T?) : Resource<T>(data)

    class Error<T>(
        error: Throwable?,
        data: T? = null,
        code: Int? = null
    ) : Resource<T>(data, error?.handleThrowable(), code)
}
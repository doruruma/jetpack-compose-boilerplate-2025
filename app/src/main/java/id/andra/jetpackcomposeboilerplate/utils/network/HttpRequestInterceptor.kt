package id.andra.jetpackcomposeboilerplate.utils.network

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class HttpRequestInterceptor(private val authProvider: AuthProvider) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url)
        request.addHeader("Authorization", "Bearer ${authProvider.token}")
        request.addHeader("Accept", "application/json")
        Timber.d(request.toString())
        return chain.proceed(request.build())
    }
}
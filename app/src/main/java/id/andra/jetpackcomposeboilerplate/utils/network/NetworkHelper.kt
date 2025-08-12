package id.andra.jetpackcomposeboilerplate.utils.network

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.io.File
import java.util.concurrent.TimeUnit

private const val CLIENT_TIME_OUT = 60L
private const val CLIENT_CACHE_SIZE = 10 * 1024 * 1024L
private const val CLIENT_CACHE_DIRECTORY = "http"

fun createMoshi(): Moshi {
    return Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
}

fun createCache(context: Context): Cache = Cache(
    directory = File(context.cacheDir, CLIENT_CACHE_DIRECTORY),
    maxSize = CLIENT_CACHE_SIZE
)

fun createHttpLoggingInterceptor(isDev: Boolean = true): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = if (isDev) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }
}

fun createHttpRequestInterceptor(authProvider: AuthProvider): Interceptor {
    return object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val request = originalRequest.newBuilder().url(originalRequest.url)
            request.addHeader("Authorization", "Bearer ${authProvider.token}")
            request.addHeader("Accept", "application/json")
            Timber.d(request.toString())
            return chain.proceed(request.build())
        }
    }
}

fun createOkHttpClient(
    context: Context,
    isDev: Boolean = true,
    isCache: Boolean = false,
    authProvider: AuthProvider? = null
): OkHttpClient {
    return OkHttpClient.Builder().apply {
        addInterceptor(createHttpLoggingInterceptor(isDev))
        if (isCache)
            cache(createCache(context))
        if (authProvider != null)
            addInterceptor(createHttpRequestInterceptor(authProvider))
        connectTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        readTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        writeTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
        followSslRedirects(true)
        followRedirects(true)
        retryOnConnectionFailure(true)
    }.build()
}

inline fun <reified T> createRetrofit(
    okHttpClient: OkHttpClient,
    moshi: Moshi,
    baseUrl: String
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    return retrofit.create(T::class.java)
}
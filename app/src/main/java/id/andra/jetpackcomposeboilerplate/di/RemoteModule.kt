package id.andra.jetpackcomposeboilerplate.di

import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.andra.jetpackcomposeboilerplate.BuildConfig
import id.andra.jetpackcomposeboilerplate.utils.network.AuthProvider
import id.andra.jetpackcomposeboilerplate.utils.network.HttpRequestInterceptor
import id.andra.jetpackcomposeboilerplate.utils.network.createHttpLoggingInterceptor
import id.andra.jetpackcomposeboilerplate.utils.network.createHttpRequestInterceptor
import id.andra.jetpackcomposeboilerplate.utils.network.createMoshi
import id.andra.jetpackcomposeboilerplate.utils.network.createOkHttpClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return createMoshi()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return createHttpLoggingInterceptor(isDev = BuildConfig.DEBUG)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
    ): OkHttpClient {
        return createOkHttpClient(
            context = context,
            isDev = BuildConfig.DEBUG,
        )
    }

    @Provides
    @Singleton
    fun provideHttpRequestInterceptor(authProvider: AuthProvider): HttpRequestInterceptor {
        return createHttpRequestInterceptor(authProvider)
    }
}
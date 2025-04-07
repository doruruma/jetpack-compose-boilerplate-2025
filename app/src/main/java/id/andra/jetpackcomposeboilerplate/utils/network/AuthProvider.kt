package id.andra.jetpackcomposeboilerplate.utils.network

import id.andra.jetpackcomposeboilerplate.utils.pref.CacheManager
import id.andra.jetpackcomposeboilerplate.utils.pref.PreferenceProvider.Companion.REFRESH_TOKEN
import id.andra.jetpackcomposeboilerplate.utils.pref.PreferenceProvider.Companion.TOKEN

class AuthProvider(
    private val cacheManager: CacheManager
) {
    var token: String
        get() = cacheManager.read(TOKEN, "")
        set(value) = cacheManager.write(TOKEN, value)

    var refreshToken: String
        get() = cacheManager.read(REFRESH_TOKEN, "")
        set(value) = cacheManager.write(REFRESH_TOKEN, value)

    fun isLogin() = token.isNotEmpty()

    fun logout(callback: () -> Unit) {
        token = ""
        refreshToken = ""
        cacheManager.clearEverything(callback)
    }
}
package id.andra.jetpackcomposeboilerplate.utils.pref

class PreferenceProvider(
    private val cacheManager: CacheManager
) {
    companion object {
        const val USER_ID = "pref_user_id"
        const val USER_NAME = "pref_user_name"
        const val TOKEN = "pref_token"
        const val REFRESH_TOKEN = "pref_refresh_token"
    }
}
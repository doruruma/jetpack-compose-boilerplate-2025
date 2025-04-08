package id.andra.jetpackcomposeboilerplate.presentation.navigation

sealed class Screen(protected val route: String, vararg params: String) {
    val fullRoute: String =
        if (params.isEmpty())
            route
        else {
            val builder = StringBuilder(route)
            params.forEach { builder.append("/{${it}}") }
            builder.toString()
        }

    sealed class NoArgumentsScreen(route: String) : Screen(route) {
        operator fun invoke(): String = route
    }

    data object HomeScreen : Screen("home_screen")
}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)
    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }
    return builder.toString()
}
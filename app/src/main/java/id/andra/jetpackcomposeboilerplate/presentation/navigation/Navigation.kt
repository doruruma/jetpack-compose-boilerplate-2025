package id.andra.jetpackcomposeboilerplate.presentation.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.andra.jetpackcomposeboilerplate.presentation.components.page.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        modifier = Modifier.fillMaxWidth(),
        navController = navController,
        startDestination = Screen.HomeScreen.fullRoute
    ) {
        composable(route = Screen.HomeScreen.fullRoute) {
            HomeScreen()
        }
    }
}
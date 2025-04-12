package id.andra.jetpackcomposeboilerplate.core.presentation.components.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import id.andra.jetpackcomposeboilerplate.core.presentation.components.atom.TextDisplayLarge
import id.andra.jetpackcomposeboilerplate.core.presentation.components.template.HomeScaffold

@Composable
fun HomeScreen(
    navController: NavController
) {
    HomeScaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextDisplayLarge(text = "Hello world")
        }
    }
}
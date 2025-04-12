package id.andra.jetpackcomposeboilerplate.core.presentation.components.template

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// you can also create Top Bar or Bottom Bar components inside this package

@Composable
fun HomeScaffold(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            content()
        }
    }
}
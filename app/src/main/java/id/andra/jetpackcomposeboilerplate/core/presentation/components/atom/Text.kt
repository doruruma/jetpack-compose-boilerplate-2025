package id.andra.jetpackcomposeboilerplate.core.presentation.components.atom

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextDisplayLarge(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.displayLarge)
}

@Composable
fun TextDisplayMedium(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.displayMedium)
}

@Composable
fun TextDisplaySmall(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.displaySmall)
}

@Composable
fun TextHeadlineLarge(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.headlineLarge)
}

@Composable
fun TextHeadlineMedium(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.headlineMedium)
}

@Composable
fun TextHeadlineSmall(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.headlineSmall)
}

@Composable
fun TextTitleLarge(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.titleLarge)
}

@Composable
fun TextTitleMedium(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.titleMedium)
}

@Composable
fun TextTitleSmall(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.titleSmall)
}

@Composable
fun TextBodyLarge(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.bodyLarge)
}

@Composable
fun TextBodyMedium(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.bodyMedium)
}

@Composable
fun TextBodySmall(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.bodySmall)
}

@Composable
fun TextLabelLarge(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.labelLarge)
}

@Composable
fun TextLabelMedium(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.labelMedium)
}

@Composable
fun TextLabelSmall(modifier: Modifier = Modifier, text: String) {
    Text(modifier = modifier, text = text, style = MaterialTheme.typography.labelSmall)
}



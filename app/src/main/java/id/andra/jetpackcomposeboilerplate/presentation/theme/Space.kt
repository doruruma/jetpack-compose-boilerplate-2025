package id.andra.jetpackcomposeboilerplate.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Space(
    val default: Dp = 1.dp,
    val quarter: Dp = 2.dp,
    val half: Dp = 4.dp,
    val smaller: Dp = 6.dp,
    val x1: Dp = 8.dp,
    val x1Half: Dp = 12.dp,
    val x2: Dp = 16.dp,
    val x3: Dp = 24.dp,
    val x4: Dp = 32.dp,
    val x4Half: Dp = 36.dp,
    val x5: Dp = 40.dp,
    val x6: Dp = 48.dp,
    val x7: Dp = 56.dp,
    val x8: Dp = 64.dp,
    val x9: Dp = 72.dp,
    val x10: Dp = 80.dp,
    val x11: Dp = 88.dp,
    val x12: Dp = 96.dp,
    val x14: Dp = 112.dp,
    val x25: Dp = 200.dp,
)

val LocalSpace = compositionLocalOf { Space() }

val space: Space
    @Composable
    @ReadOnlyComposable
    get() = LocalSpace.current
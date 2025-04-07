package id.andra.jetpackcomposeboilerplate.presentation.components.atom

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import id.andra.jetpackcomposeboilerplate.presentation.theme.space

@Composable
fun Button(
    modifier: Modifier = Modifier,
    iconResId: Int = 0,
    iconSize: Dp = space.x3,
    label: String = "",
    isLoading: Boolean = false,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(space.x5.plus(space.quarter))
            .clip(RoundedCornerShape(space.x1))
            .clickable {
                if (!isEnabled) return@clickable
                onClick.invoke()
            }
            .padding(horizontal = space.x1Half),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!isLoading && iconResId > 0) {
                Icon(
                    painter = painterResource(id = iconResId),
                    contentDescription = "label",
                    modifier = Modifier.size(
                        iconSize
                    ),
                )
            }

            if (!isLoading && iconResId > 0 && label.isNotEmpty()) {
                Spacer(modifier = Modifier.width(space.x1))
            }

            if (!isLoading && label.isNotEmpty()) {
                TextButton(text = label, fontWeight = FontWeight.Bold)
            }
        }

        AnimatedVisibility(
            visible = isLoading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(space.x1Half)
                    .size(space.x3)
                    .align(Alignment.Center),
            )
        }
    }
}
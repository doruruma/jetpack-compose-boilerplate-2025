package id.andra.jetpackcomposeboilerplate.presentation.components.atom

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import id.andra.jetpackcomposeboilerplate.presentation.theme.space
import id.andra.jetpackcomposeboilerplate.presentation.theme.textBody2
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BaseInput(
    modifier: Modifier = Modifier,
    value: String,
    placeholderLabel: String,
    isPassword: Boolean = false,
    isNumber: Boolean = false,
    readonly: Boolean = false,
    isMultiline: Boolean = false,
    isShowBorder: Boolean = true,
    backgroundColor: Color = Color.Transparent,
    isNextSoftKeyboard: Boolean = false,
    onTextChanged: (String) -> Unit = {},
    trailingIconResId: Int = 0,
    height: Dp = space.inputHeight,
    horizontalTextPadding: Dp = space.x2,
    onDone: (String) -> Unit = {},
    onTrailingIconClick: (() -> Unit?)? = null,
    onClick: () -> Unit = {},
) {
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    val visualTransformation: VisualTransformation =
        if (!isPasswordVisible && isPassword) PasswordVisualTransformation()
        else VisualTransformation.None
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    val focusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()
    val bringIntoViewRequester = remember { BringIntoViewRequester() }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(space.smaller)
            )
            .then(
                if (isShowBorder)
                    Modifier
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.outline,
                            shape = RoundedCornerShape(space.smaller)
                        )
                        .clip(RoundedCornerShape(space.smaller))
                else
                    Modifier
            )
            .padding(
                horizontal = horizontalTextPadding,
                vertical = if (isMultiline) horizontalTextPadding else 0.dp
            )
            .bringIntoViewRequester(bringIntoViewRequester)
            .onFocusChanged {
                if (it.isFocused) {
                    coroutineScope.launch {
                        delay(200)
                        bringIntoViewRequester.bringIntoView()
                    }
                }
            }
            .clickable { onClick.invoke() },
        value = value,
        onValueChange = { onTextChanged.invoke(it) },
        textStyle = textBody2.copy(
            fontWeight = FontWeight.Medium
        ),
        readOnly = readonly,
        visualTransformation = visualTransformation,
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                onDone.invoke(value)
            }
        ),
        keyboardOptions = when {
            isPassword -> KeyboardOptions(keyboardType = KeyboardType.Password)
            isNumber -> KeyboardOptions(keyboardType = KeyboardType.Number)
            !isNextSoftKeyboard -> KeyboardOptions.Default
            else -> KeyboardOptions(imeAction = ImeAction.Next)
        },
        interactionSource = interactionSource,
        singleLine = !isMultiline,
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(Modifier.weight(1f)) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholderLabel,
                            color = MaterialTheme.colorScheme.onSurface,
                            style = textBody2
                        )
                    }
                    innerTextField()
                }
                if (isPassword || trailingIconResId != 0) {
                    Spacer(modifier = Modifier.width(8.dp))
                    if (isPassword) {
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            Icon(
                                imageVector =
                                if (isPasswordVisible) Icons.Filled.Visibility
                                else Icons.Filled.VisibilityOff,
                                contentDescription = "password"
                            )
                        }
                    }
                    if (trailingIconResId != 0) {
                        Icon(
                            painter = painterResource(id = trailingIconResId),
                            contentDescription = placeholderLabel,
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(space.x1Half))
                                .clickable {
                                    onTrailingIconClick?.invoke() ?: onDone.invoke(value)
                                }
                                .size(space.x3)
                                .padding(space.half)
                        )
                    }
                }
            }
        }
    )
}
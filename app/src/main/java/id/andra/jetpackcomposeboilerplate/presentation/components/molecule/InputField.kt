package id.andra.jetpackcomposeboilerplate.presentation.components.molecule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import id.andra.jetpackcomposeboilerplate.presentation.components.atom.BaseInput
import id.andra.jetpackcomposeboilerplate.presentation.components.atom.TextBody2
import id.andra.jetpackcomposeboilerplate.presentation.components.atom.TextCaptionS
import id.andra.jetpackcomposeboilerplate.presentation.theme.DangerMain
import id.andra.jetpackcomposeboilerplate.presentation.theme.space

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String,
    errorMsg: String,
    value: String,
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
    Column(modifier = modifier) {
        TextBody2(text = label)
        Spacer(modifier = Modifier.height(space.x1))
        BaseInput(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            placeholderLabel = placeholder,
            isPassword = isPassword,
            isNumber = isNumber,
            readonly = readonly,
            isMultiline = isMultiline,
            isShowBorder = isShowBorder,
            backgroundColor = backgroundColor,
            isNextSoftKeyboard = isNextSoftKeyboard,
            onTextChanged = onTextChanged,
            trailingIconResId = trailingIconResId,
            height = height,
            horizontalTextPadding = horizontalTextPadding,
            onDone = onDone,
            onTrailingIconClick = onTrailingIconClick,
            onClick = onClick,
        )
    }
    Spacer(modifier = Modifier.height(space.half))
    TextCaptionS(
        text = errorMsg,
        fontWeight = FontWeight.Medium,
        color = DangerMain
    )
    Spacer(modifier = Modifier.height(space.x2))
}
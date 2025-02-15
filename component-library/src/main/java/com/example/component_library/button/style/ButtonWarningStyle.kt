package com.example.component_library.button.style

import androidx.compose.runtime.Composable
import com.example.component_library.button.colors.ButtonColorSelector
import com.example.component_library.button.colors.ButtonColors
import com.example.component_library.button.colors.Colors

object ButtonWarningStyle {
    @Composable
    fun buttonWarningStyle(): ButtonStyle{
        return ButtonStyle(
            colorSelector = ButtonColorSelector(
                defaultColors = ButtonColors(
                    containerColor = Colors.WARNING,
                    contentColor = Colors.WHITE,
                    labelColor = Colors.WARNING
                ),
                disabledColors = ButtonColors(
                    containerColor = Colors.disabled,
                    contentColor = Colors.disabledContent,
                    labelColor = Colors.disabledContent
                )
            )
        )
    }
}
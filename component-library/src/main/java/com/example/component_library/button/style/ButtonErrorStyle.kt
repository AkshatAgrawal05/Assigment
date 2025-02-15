package com.example.component_library.button.style

import androidx.compose.runtime.Composable
import com.example.component_library.button.colors.ButtonColorSelector
import com.example.component_library.button.colors.ButtonColors
import com.example.component_library.button.colors.Colors

object ButtonErrorStyle {
    @Composable
    fun buttonErrorStyle(): ButtonStyle{
        return ButtonStyle(
            colorSelector = ButtonColorSelector(
                defaultColors = ButtonColors(
                    containerColor = Colors.ERROR,
                    contentColor = Colors.WHITE,
                    labelColor = Colors.ERROR
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
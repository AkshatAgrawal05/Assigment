package com.example.component_library.button.colors

import androidx.compose.ui.graphics.Color

data class ButtonColors(
    val containerColor: Color,
    val contentColor: Color,
    val labelColor: Color
)

object Colors{
    val interactive = Color(0xFF0243B4)
    val disabledContent = Color.DarkGray
    val default = Color(0xFF000000)
    val background = Color(0xFFFFFFFF)
    val WHITE =  Color(0xFFFFFFFF)
    val disabled = Color.LightGray
    val ERROR = Color.Red
    val WARNING = Color(0xFFE5D234)
}

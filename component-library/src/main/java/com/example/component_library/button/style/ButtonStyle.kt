package com.example.component_library.button.style

import com.example.component_library.button.colors.ButtonColorSelector

data class ButtonStyle(
    val colorSelector: ButtonColorSelector
)

enum class ButtonStyleState{
    DEFAULT, WARNING, ERROR
}

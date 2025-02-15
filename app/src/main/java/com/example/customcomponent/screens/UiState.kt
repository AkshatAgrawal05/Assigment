package com.example.customcomponent.screens

import com.example.component_library.button.ButtonState
import com.example.component_library.button.style.ButtonStyleState

data class UiState(
    val buttonState: ButtonState = ButtonState.DEFAULT,
    val buttonStyle: ButtonStyleState = ButtonStyleState.DEFAULT,
    val icon: Int = com.example.component_library.R.drawable.ic_add,
    val title: String? = "Title"
)

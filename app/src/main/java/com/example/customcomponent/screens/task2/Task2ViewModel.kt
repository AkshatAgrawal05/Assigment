package com.example.customcomponent.screens.task2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.component_library.button.ButtonState
import com.example.component_library.button.style.ButtonStyleState
import com.example.customcomponent.screens.UiState

class Task2ViewModel: ViewModel() {

    var button1UiState by mutableStateOf(UiState(title = "Title 1"))

    var button2UiState by mutableStateOf(UiState(title = "Title 2"))

    var button3UiState by mutableStateOf(UiState(title = "Title 3"))


    fun updateButton1State(state: ButtonState){
        button1UiState = button1UiState.copy(
            buttonState = state
        )
    }

    fun updateButton1Style(style: ButtonStyleState) {
        button1UiState = button1UiState.copy(
            buttonStyle = style
        )
    }

    fun updateButton1Icon(icon: Int) {
        button1UiState = button1UiState.copy(
            icon = icon
        )
    }

    fun updateButton1Title(title: String) {
        button1UiState = button1UiState.copy(
            title = title
        )
    }

    fun updateButton2State(state: ButtonState){
        button2UiState = button2UiState.copy(
            buttonState = state
        )
    }

    fun updateButton2Style(style: ButtonStyleState) {
        button2UiState = button2UiState.copy(
            buttonStyle = style
        )
    }

    fun updateButton2Icon(icon: Int) {
        button2UiState = button2UiState.copy(
            icon = icon
        )
    }

    fun updateButton2Title(title: String) {
        button2UiState = button2UiState.copy(
            title = title
        )
    }

    fun updateButton3State(state: ButtonState){
        button3UiState = button3UiState.copy(
            buttonState = state
        )
    }

    fun updateButton3Style(style: ButtonStyleState) {
        button3UiState = button3UiState.copy(
            buttonStyle = style
        )
    }

    fun updateButton3Icon(icon: Int) {
        button3UiState = button3UiState.copy(
            icon = icon
        )
    }

    fun updateButton3Title(title: String) {
        button3UiState = button3UiState.copy(
            title = title
        )
    }
}
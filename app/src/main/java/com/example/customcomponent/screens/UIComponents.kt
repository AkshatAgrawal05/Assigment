package com.example.customcomponent.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.component_library.button.ButtonState
import com.example.component_library.button.style.ButtonStyleState

@Composable
fun DropDownButtonState(onStateSelected: (state: ButtonState) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(ButtonState.DEFAULT) }
    val options = ButtonState.entries

    Box {
        TextButton(onClick = { expanded = true }) {
            Text(selectedOption.name)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selectedOption = option
                        expanded = false
                        onStateSelected(selectedOption)
                    },
                    text = {
                        Text(option.name)
                    }
                )
            }
        }
    }
}

@Composable
fun DropDownButtonStyleState(onStateSelected: (state: ButtonStyleState) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(ButtonStyleState.DEFAULT) }
    val options = ButtonStyleState.entries

    Box {
        TextButton(onClick = { expanded = true }) {
            Text(selectedOption.name)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selectedOption = option
                        expanded = false
                        onStateSelected(selectedOption)
                    },
                    text = {
                        Text(option.name)
                    }
                )
            }
        }
    }
}

@Composable
fun DropDownIconState(onStateSelected: (state: Int) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val icon = painterResource(com.example.component_library.R.drawable.ic_add)
    var selectedOption by remember { mutableStateOf(IconDropdownItem(icon = icon, title = "Add", id = com.example.component_library.R.drawable.ic_add)) }
    val options = listOf(
        IconDropdownItem(icon = painterResource(com.example.component_library.R.drawable.ic_add), title = "Add", id = com.example.component_library.R.drawable.ic_add),
        IconDropdownItem(icon = painterResource(com.example.component_library.R.drawable.ic_error), title = "Error", com.example.component_library.R.drawable.ic_error),
        IconDropdownItem(icon = painterResource(com.example.component_library.R.drawable.ic_warning), title = "Warning", id = com.example.component_library.R.drawable.ic_warning),
    )

    Box {
        IconButton(onClick = { expanded = true }) {
            Icon(painter = selectedOption.icon, contentDescription = selectedOption.title)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selectedOption = option
                        expanded = false
                        onStateSelected(selectedOption.id)
                    },
                    text = {
                        Icon(painter = option.icon, contentDescription = option.title)
                    }
                )
            }
        }
    }
}

data class IconDropdownItem(
    val icon: Painter,
    val title: String,
    val id: Int
)
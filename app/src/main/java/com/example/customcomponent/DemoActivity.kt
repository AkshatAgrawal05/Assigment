package com.example.customcomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.customcomponent.navigation.Navigation
import com.example.customcomponent.ui.theme.CustomComponentTheme

class DemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CustomComponentTheme (
                darkTheme = false
            ){
                Navigation(navController)
            }
        }
    }
}

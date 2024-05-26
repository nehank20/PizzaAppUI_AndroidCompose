package com.example.nehank.pizzaapp_ui_androidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nehank.pizzaapp_ui_androidcompose.common_ui.SpacerHeight
import com.example.nehank.pizzaapp_ui_androidcompose.screen.CustomFloatingActionButton
import com.example.nehank.pizzaapp_ui_androidcompose.screen.HomeScreen
import com.example.nehank.pizzaapp_ui_androidcompose.ui.theme.PizzaApp_UI_AndroidComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaApp_UI_AndroidComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        floatingActionButton = {
                            CustomFloatingActionButton()
                        }
                    ) {
                        Spacer(modifier = Modifier.height(it.calculateTopPadding()))
                        HomeScreen()
                    }
                }
            }
        }
    }
}

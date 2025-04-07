package id.andra.jetpackcomposeboilerplate.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import id.andra.jetpackcomposeboilerplate.presentation.components.atom.TextBody1
import id.andra.jetpackcomposeboilerplate.presentation.theme.AppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                TextBody1(text = "Hello World")
            }
        }
    }

}
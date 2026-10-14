package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardApp()
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    BusinessCardTheme {
        Surface(
            modifier = modifier
        ) {

        }
    }
}

@Composable
fun ContactCard(contact: String, modifier: Modifier = Modifier) {
    Row() {
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardApp()
}
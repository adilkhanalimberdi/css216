package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.data.HeroesRepository
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                SuperheroesApp()
            }
        }
    }
}

@Composable
fun SuperheroesApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        HeroesList(
            heroes = HeroesRepository.heroes,
            contentPadding = innerPadding
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroesPreview() {
    SuperheroesTheme {
        SuperheroesApp()
    }
}
package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleApp()
        }
    }
}

@Composable
fun ComposeArticleApp(modifier: Modifier = Modifier) {
    ComposeArticleTheme {
        Surface(
            modifier = modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top)
            ) {
                Image(
                    painter = painterResource(R.drawable.bg_compose_background),
                    contentDescription = null,
                    modifier = modifier.fillMaxWidth()
                )

                Text(
                    text = stringResource(R.string.title),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )

                Text(
                    text = stringResource(R.string.subtitle),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )

                Text(
                    text = stringResource(R.string.content),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleApp()
}
package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

data class Artwork(
    val image: Int,
    val title: Int,
    val author: Int,
    val year: Int
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            ArtSpaceApp()
        }
    }
}

@Composable
fun ArtSpaceContent(modifier: Modifier = Modifier) {
    val artworks = listOf(
        Artwork(
            image = R.drawable.image_1,
            title = R.string.title_1,
            author = R.string.author_1,
            year = R.string.year_1
        ),
        Artwork(
            image = R.drawable.image_2,
            title = R.string.title_2,
            author = R.string.author_2,
            year = R.string.year_2
        ),
        Artwork(
            image = R.drawable.image_3,
            title = R.string.title_3,
            author = R.string.author_3,
            year = R.string.year_3
        )
    )

    var index by rememberSaveable {
        mutableIntStateOf(0)
    }

    val artwork = artworks[index]

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = painterResource(artwork.image),
            contentDescription = stringResource(artwork.title),
            modifier = Modifier.size(300.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(artwork.title),
                fontSize = 48.sp,
                fontWeight = FontWeight.Thin
            )
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = stringResource(artwork.author),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "(${stringResource(artwork.year)})"
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Button(
                onClick = { index = (index - 1 + artworks.size) % artworks.size },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Previous"
                )
            }

            Button(
                onClick = { index = (index + 1) % artworks.size },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Next"
                )
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    ArtSpaceTheme {
        Surface(
            modifier = modifier.fillMaxSize()
        ) {
            ArtSpaceContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
}

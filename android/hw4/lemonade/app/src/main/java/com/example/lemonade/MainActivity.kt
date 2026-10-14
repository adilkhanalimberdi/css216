package com.example.lemonade

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeApp()
        }
    }
}

enum class LemonadeState {
    START,
    SQUEEZE,
    DRINK,
    RESTART
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    LemonadeTheme {
        Surface(
            modifier = modifier.fillMaxSize()
        ) {
            Column {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(color = Color.Yellow),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = stringResource(R.string.lemonade),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 18.dp)
                    )
                }

                Column(
                    modifier = Modifier.weight(9f)
                ) {
                    LemonadeContent()
                }
            }
        }
    }
}

@Composable
fun LemonadeContent(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(LemonadeState.START) }
    var repeat by remember { mutableIntStateOf(1) }

    fun transition() {
        if (repeat > 1) {
            repeat -= 1;
            return;
        }

        state = when (state) {
            LemonadeState.START -> LemonadeState.SQUEEZE
            LemonadeState.SQUEEZE -> LemonadeState.DRINK
            LemonadeState.DRINK -> LemonadeState.RESTART
            LemonadeState.RESTART -> LemonadeState.START
        }

        repeat = if (state == LemonadeState.SQUEEZE) (1..5).random() else 1
    }

    val imageResource = when (state) {
        LemonadeState.START -> R.drawable.lemon_tree
        LemonadeState.SQUEEZE -> R.drawable.lemon_squeeze
        LemonadeState.DRINK -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textResource = when (state) {
        LemonadeState.START -> R.string.start
        LemonadeState.SQUEEZE -> R.string.squeeze
        LemonadeState.DRINK -> R.string.drink
        else -> R.string.restart
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { transition() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB1ECC8)
            ),
            elevation = null,
            shape = RoundedCornerShape(12.dp),
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = state.toString()
            )
        }

        Text(
            text = stringResource(textResource)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeApp()
}
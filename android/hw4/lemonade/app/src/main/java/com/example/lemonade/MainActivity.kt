package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.runtime.saveable.rememberSaveable
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

enum class LemonadeState(
    val image: Int,
    val text: Int,
    val description: Int
) {
    START(
        image = R.drawable.lemon_tree,
        text = R.string.start,
        description = R.string.lemon_tree
    ),
    SQUEEZE(
        image = R.drawable.lemon_squeeze,
        text = R.string.squeeze,
        description = R.string.lemon
    ),
    DRINK(
        image = R.drawable.lemon_drink,
        text = R.string.drink,
        description = R.string.glass_of_lemonade
    ),
    RESTART(
        image = R.drawable.lemon_restart,
        text = R.string.restart,
        description = R.string.empty_glass
    ),
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
    var state by rememberSaveable { mutableStateOf(LemonadeState.START) }
    var steps by rememberSaveable { mutableIntStateOf(1) }

    fun transition() {
        if (steps > 1) {
            steps -= 1
            return
        }

        state = when (state) {
            LemonadeState.START -> LemonadeState.SQUEEZE
            LemonadeState.SQUEEZE -> LemonadeState.DRINK
            LemonadeState.DRINK -> LemonadeState.RESTART
            LemonadeState.RESTART -> LemonadeState.START
        }

        steps = if (state == LemonadeState.SQUEEZE) (1..5).random() else 1
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
                painter = painterResource(state.image),
                contentDescription = stringResource(state.description)
            )
        }

        Text(
            text = stringResource(state.text)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeApp()
}
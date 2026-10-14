package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

private val AccentPurple = Color(0xFF6200EE)

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
            modifier = modifier.fillMaxSize(),
            color = Color(0xFFDCD7E5)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BusinessCard(
                        fullName = "Adilkhan Kerimshe",
                        speciality = "Java Software Engineer"
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 45.dp, end = 45.dp, bottom = 36.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Bottom),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ContactCard(
                        contact = "+7 (771) 671 2905",
                        icon = Icons.Filled.Phone,
                        modifier = Modifier.fillMaxWidth()
                    )
                    ContactCard(
                        contact = "Almaty, Kazakhstan",
                        icon = Icons.Filled.LocationOn,
                        modifier = Modifier.fillMaxWidth()
                    )
                    ContactCard(
                        contact = "adilkhankerimshe@gmail.com",
                        icon = Icons.Filled.Email,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    fullName: String,
    speciality: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.adilkhan),
            contentDescription = "Photo of Adilkhan",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(196.dp)
                .clip(CircleShape)
                .border(3.dp, Color(0xFF9870D9), CircleShape)
        )
        Text(
            text = fullName,
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
        )
        Text(
            text = speciality,
            color = AccentPurple
        )
    }
}

@Composable
fun ContactCard(
    contact: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            tint = AccentPurple
        )
        Text(
            text = contact,
            modifier = Modifier.padding(start = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardApp()
}
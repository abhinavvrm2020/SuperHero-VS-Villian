package com.example.superherovsvillian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superherovsvillian.ui.theme.SuperHeroVsVillianTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.CenterAlignedTopAppBar
import com.example.superherovsvillian.model.SuperHeroDataSource
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superherovsvillian.model.SuperVillainDataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroVsVillianTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperheroesApp()

                }
            }
        }
    }
}

@Composable
fun SuperheroesApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ) {
        val heroes = SuperHeroDataSource.heroes
        val villains= SuperVillainDataSource.villains
        SuperHeros(heroes = heroes, villains = villains, contentPadding = it)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row {
                Image(painter = painterResource(R.drawable.avengers_logo), contentDescription =null,
                    modifier= Modifier.size(52.dp).padding(end = 8.dp))
                Text(
                    text = stringResource(R.string.app_name),
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(4.dp)
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun SuperHeroesPreview() {
    SuperHeroVsVillianTheme {
        SuperheroesApp()
    }
}

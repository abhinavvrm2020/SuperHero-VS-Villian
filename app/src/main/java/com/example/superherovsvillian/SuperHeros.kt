package com.example.superherovsvillian

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Spring.DampingRatioHighBouncy
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superherovsvillian.model.SuperHero
import com.example.superherovsvillian.ui.theme.SuperHeroVsVillianTheme
import com.example.superherovsvillian.model.SuperHeroDataSource
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.height
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.superherovsvillian.model.SuperVillain

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SuperHeros(
    heroes: List<SuperHero>,
    villains: List<SuperVillain>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
        ),
        exit = fadeOut(),
        modifier = modifier
    ) {


        Column {
            LazyColumn(contentPadding = contentPadding) {

                item {
                    Spacer(modifier = modifier.padding(16.dp))
                    CardHeading(title = "Super Heroes",modifier)
                    Spacer(modifier = modifier.padding(16.dp))
                }

                itemsIndexed(heroes) { index, hero ->
                    HeroListItem(
                        hero = hero,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .animateEnterExit(
                                enter = slideInVertically(
                                    animationSpec = spring(
                                        stiffness = StiffnessVeryLow,
                                        dampingRatio = DampingRatioLowBouncy
                                    ),
                                    initialOffsetY = { it * (index + 1) }
                                )
                            )
                    )
                }

                item {
                    Spacer(modifier = modifier.padding(16.dp))
                    CardHeading(title = "Super Villains",modifier)
                    Spacer(modifier = modifier.padding(16.dp))
                }
                
                itemsIndexed(villains) { index, villain ->
                    VillainListItem(
                        villain = villain,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .animateEnterExit(
                                enter = slideInVertically(
                                    animationSpec = spring(
                                        stiffness = StiffnessVeryLow,
                                        dampingRatio = DampingRatioLowBouncy
                                    ),
                                    initialOffsetY = { it * (index + 1) }
                                )
                            )
                    )
                }
            }


        }



        
    }

}

@Composable
fun CardHeading(title: String, modifier: Modifier= Modifier){   
    Box(
        modifier = modifier.fillMaxWidth()
            .padding(0.dp),
        contentAlignment = Alignment.Center

    ) {
        Text(text = title,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            ),

            textAlign = TextAlign.Center)        }

    }



@Composable
fun HeroListItem(
    hero: SuperHero,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer)

    Card(

        modifier = modifier
            .clickable { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()

                .sizeIn(minHeight = 72.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color= color)

        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(4.dp)

            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(hero.nameRes),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = stringResource(hero.descriptionRes),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                Spacer(Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Image(
                        modifier = modifier
                            .size(64.dp)
                            .clip(MaterialTheme.shapes.small),
                        painter = painterResource(hero.imageRes),
                        contentDescription = null,
                        alignment = Alignment.TopCenter,
                        contentScale = ContentScale.Crop
                    )
                }
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(hero.expandedDescription),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(4.dp)
                )
            }
        }
    }
}


@Composable
fun VillainListItem(
    villain: SuperVillain,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer)

    Card(

        modifier = modifier
            .clickable { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()

                .sizeIn(minHeight = 72.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color= color)

        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(4.dp)

            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(villain.nameRes),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = stringResource(villain.descriptionRes),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                Spacer(Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Image(
                        modifier = modifier
                            .size(64.dp)
                            .clip(MaterialTheme.shapes.small),
                        painter = painterResource(villain.imageRes),
                        contentDescription = null,
                        alignment = Alignment.TopCenter,
                        contentScale = ContentScale.Crop
                    )
                }
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(villain.expandedDescription),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier.padding(4.dp)
                )
            }
        }
    }
}


@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroPreview() {
    val hero = SuperHero(
        R.string.hero1,
        R.string.description1,
        R.string.expanded_description1,
        R.drawable.photo_yashu
    )
    SuperHeroVsVillianTheme {
        HeroListItem(hero = hero)
    }
}

@Preview("Heroes List")
@Composable
fun HeroesPreview() {
    SuperHeroVsVillianTheme(darkTheme = false) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
          //  SuperHeros(heroes = SuperHeroDataSource.heroes)
        }
    }
}
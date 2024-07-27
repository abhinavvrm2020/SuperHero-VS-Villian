package com.example.superherovsvillian.model

import com.example.superherovsvillian.R;

object SuperHeroDataSource {
    val heroes = listOf(
        SuperHero(
            nameRes = R.string.hero1,
            descriptionRes = R.string.description1,
            expandedDescription = R.string.expanded_description1,
            imageRes = R.drawable.android_superhero1
        ),
        SuperHero(
            nameRes = R.string.hero2,
            descriptionRes = R.string.description2,
            expandedDescription = R.string.expanded_description2,
            imageRes = R.drawable.android_superhero2
        ),
        SuperHero(
            nameRes = R.string.hero3,
            descriptionRes = R.string.description3,
            expandedDescription = R.string.expanded_description3,
            imageRes = R.drawable.android_superhero3
        ),
        SuperHero(
            nameRes = R.string.hero4,
            descriptionRes = R.string.description4,
            expandedDescription = R.string.expanded_description4,
            imageRes = R.drawable.android_superhero4
        )
    )
}
package com.example.superherovsvillian.model

import com.example.superherovsvillian.R;

object SuperHeroDataSource {
    val heroes = listOf(
        SuperHero(
            nameRes = R.string.hero1,
            descriptionRes = R.string.description1,
            expandedDescription = R.string.expanded_description1,
            imageRes = R.drawable.photo_yashu
        ),
        SuperHero(
            nameRes = R.string.hero2,
            descriptionRes = R.string.description2,
            expandedDescription = R.string.expanded_description2,
            imageRes = R.drawable.photo_ram
        ),
        SuperHero(
            nameRes = R.string.hero3,
            descriptionRes = R.string.description3,
            expandedDescription = R.string.expanded_description3,
            imageRes = R.drawable.photo_harsh
        ),
        SuperHero(
            nameRes = R.string.hero4,
            descriptionRes = R.string.description4,
            expandedDescription = R.string.expanded_description4,
            imageRes = R.drawable.photo_veer
        )
    )
}

object SuperVillainDataSource{

    val villains= listOf(
        SuperVillain(
            nameRes = R.string.villain1,
            descriptionRes = R.string.description3,
            expandedDescription = R.string.expanded_description3,
            imageRes = R.drawable.photo_tushar),
        SuperVillain(
            nameRes = R.string.villain2,
            descriptionRes = R.string.description2,
            expandedDescription = R.string.expanded_description2,
            imageRes = R.drawable.photo_shivam),
        SuperVillain(
            nameRes = R.string.villain3,
            descriptionRes = R.string.description3,
            expandedDescription = R.string.expanded_description3,
            imageRes = R.drawable.photo_nand),
        SuperVillain(
            nameRes = R.string.villain4,
            descriptionRes = R.string.description3,
            expandedDescription = R.string.expanded_description3,
            imageRes = R.drawable.photo_hanu),



    )

}
package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strDrinkAlternate: String?,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strTags: String?,
    val strYoutube: String,
    val ingredients: List<String?>,
    val measures: List<String?>,
    val strSource: String?,
    var fav: Boolean,
    var star: Int,
    var comment: String?
) : Parcelable

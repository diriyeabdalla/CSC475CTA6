package com.example.culinarycompanion.model

import com.example.culinarycompanion.Recipe

data class RecipeSearchResponse(
    val results: List<Recipe>
)
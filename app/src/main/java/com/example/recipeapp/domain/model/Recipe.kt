package com.example.recipeapp.domain.model


data class Recipe (
    val id : Int? = null,
    val cookingInstructions: String? = null,
    val dateAdded: String? = null,
    val dateUpdated: String? = null,
    val description: String? = null,
    val featuredImage: String? = null,
    val ingredients: List<String> = listOf(),
    val publisher: String? = null,
    val rating: Int? = 0,
    val sourceUrl: String? = null,
    val title: String? = null
        )
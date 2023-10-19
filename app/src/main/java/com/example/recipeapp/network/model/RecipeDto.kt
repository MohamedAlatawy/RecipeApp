package com.example.recipeapp.network.model

import com.google.gson.annotations.SerializedName



data class RecipeDto(
    @SerializedName("cooking_instructions")
    var cookingInstructions: String? = null,

    @SerializedName("date_added")
    var dateAdded: String? = null,

    @SerializedName("date_updated")
    var dateUpdated: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("featured_image")
    var featuredImage: String? = null,

    @SerializedName("ingredients")
    var ingredients: List<String>? = null,

    @SerializedName("long_date_added")
    var longDateAdded: Int? = null,

    @SerializedName("long_date_updated")
    var longDateUpdated: Int? = null,

    @SerializedName("pk")
    var pk: Int? = null,

    @SerializedName("publisher")
    var publisher: String? = null,

    @SerializedName("rating")
    var rating: Int? = null,

    @SerializedName("source_url")
    var sourceUrl: String? = null,

    @SerializedName("title")
    var title: String? = null
)
package com.example.recipeapp.repository

import com.example.recipeapp.domain.model.Recipe
import retrofit2.http.Query

interface RecipeRepository {

    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe

}
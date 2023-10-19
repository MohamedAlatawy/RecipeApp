package com.example.recipeapp.presentation.navigation

sealed class Screen(val route: String){

    object RecipeListScreen : Screen("recipe_list_screen")
    object RecipeScreen : Screen("recipe_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { args ->
                append("/$args")
            }
        }
    }

}

package com.example.recipeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipeapp.presentation.BaseApplication
import com.example.recipeapp.presentation.ui.recipe.RecipeScreen
import com.example.recipeapp.presentation.ui.recipe_list.RecipeListScreen

@Composable
fun Navigation(app: BaseApplication) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeListScreen.route) {

        composable(route = Screen.RecipeListScreen.route) {
            RecipeListScreen(application = app, navController = navController)
        }

        composable(
            route = Screen.RecipeScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                    defaultValue = "-1"
                    nullable = true
                }
            )
        ) { entry ->
            RecipeScreen( application = app, id = entry.arguments?.getString("id"))
        }
    }
}
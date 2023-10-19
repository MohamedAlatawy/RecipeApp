package com.example.recipeapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipeapp.domain.model.Recipe
import com.example.recipeapp.presentation.navigation.Screen
import com.example.recipeapp.presentation.ui.recipe_list.PAGE_SIZE
import com.example.recipeapp.presentation.ui.recipe_list.RecipeListEvent

@Composable
fun RecipeList(
    navController: NavController,
    loading: Boolean,
    recipes: List<Recipe>,
    onChangeRecipeScrollPosition: (Int) -> Unit,
    page: Int,
    onNextPage: (RecipeListEvent) -> Unit,
){
    val scrollState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface)
    ){
        LazyColumn(
            modifier = Modifier.padding(5.dp),
            state = scrollState
        ) {
            // We use itemsIndexed to get the index of each item
            itemsIndexed(recipes) { index, item ->
                onChangeRecipeScrollPosition(index)
                if ((index + 1) >= (page * PAGE_SIZE) && !loading){
                    onNextPage(RecipeListEvent.NextPageEvent)
                }
                RecipeCard(
                    recipe = item,
                    onClick = {
                        navController.navigate(Screen.RecipeScreen.withArgs(item.id.toString()))
                    }
                )
            }
        }
        CircularIndeterminateProgressBar(isDisplayed = loading)
    }
}
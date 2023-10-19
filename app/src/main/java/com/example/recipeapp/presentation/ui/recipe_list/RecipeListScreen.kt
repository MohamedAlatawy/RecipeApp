package com.example.recipeapp.presentation.ui.recipe_list

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.recipeapp.presentation.BaseApplication
import com.example.recipeapp.presentation.components.RecipeList
import com.example.recipeapp.presentation.components.SearchAppBar



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipeListScreen(
    application: BaseApplication,
    navController: NavController
) {


    val viewModel: RecipeListViewModel = hiltViewModel()

    val recipes = viewModel.recipes.value

    val query = viewModel.query.value
    
    val selectedCategory = viewModel.selectedCategory.value

    val loading = viewModel.loading.value

    val page = viewModel.page.value

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        drawerGesturesEnabled = false,
        topBar = {
            SearchAppBar(
                query = query,
                onQueryChanged = viewModel::onQueryChanged,
                onExecuteSearch = {
                    viewModel.onTriggerEvent(RecipeListEvent.NewSearchEvent)
                },
                scrollPosition = viewModel.categoryScrollPosition,
                selectedCategory = selectedCategory,
                onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                onChangeCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition,
                onToggleTheme = {
                    application.toggleLightTheme()
                }
            )
        },
        drawerContent = {},
        bottomBar = {},
        scaffoldState = scaffoldState
    ) {
        RecipeList(
            navController = navController,
            loading = loading,
            recipes = recipes,
            onChangeRecipeScrollPosition = viewModel::onChangeRecipeScrollPosition,
            page = page,
            onNextPage = {
                viewModel.onTriggerEvent(RecipeListEvent.NextPageEvent)
            }
        )
    }
}











package com.example.recipeapp.presentation.ui.recipe

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.navArgument
import com.example.recipeapp.presentation.BaseApplication
import com.example.recipeapp.presentation.components.CircularIndeterminateProgressBar
import com.example.recipeapp.presentation.components.RecipeView
import com.example.recipeapp.presentation.ui.theme.RecipeAppTheme
import javax.inject.Inject

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipeScreen( application: BaseApplication, id: String? ) {

    val recipeId = remember {
        mutableStateOf(id?.toInt())
    }

    val viewModel: RecipeViewModel = hiltViewModel()

    viewModel.onTriggerEvent(RecipeEvent.GetRecipeEvent(recipeId.value))

    val loading = viewModel.loading.value

    val recipe = viewModel.recipe.value

    val scaffoldState = rememberScaffoldState()

    RecipeAppTheme(darkTheme = application.isDark.value) {
        Scaffold(
            scaffoldState = scaffoldState,
        ) {
            Box(modifier = Modifier.fillMaxSize()){
                    recipe?.let {
                        RecipeView(recipe = it)
                    }
                CircularIndeterminateProgressBar(isDisplayed = loading, )
            }
        }
    }
}










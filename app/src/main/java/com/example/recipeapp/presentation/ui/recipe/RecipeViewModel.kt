package com.example.recipeapp.presentation.ui.recipe

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.domain.model.Recipe
import com.example.recipeapp.repository.RecipeRepository
import com.example.recipeapp.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    @Named("auth_token") private val token: String
) : ViewModel() {

    val recipe: MutableState<Recipe?> = mutableStateOf(null)

    val loading = mutableStateOf(false)

//    private val recipeId: MutableState<Int?> = mutableStateOf(null)
//    val myVariable: MutableState<Int?> get() = recipeId
//
//    fun setRecipeId(value: Int) {
//        recipeId.value = value
//    }

//    init {
//        onTriggerEvent(RecipeEvent.GetRecipeEvent(recipeId.value))
//    }

    fun onTriggerEvent(event: RecipeEvent) {
        viewModelScope.launch {
            try {
                when(event){
                    is RecipeEvent.GetRecipeEvent -> {
                        if(recipe.value == null){
                            event.id?.let { getRecipe(it) }
                        }
                    }
                }
            }catch (e: Exception){
                Log.e(TAG,"onTriggerEvent: Exception $e , ${e.cause}")
            }
        }
    }

    private suspend fun getRecipe(id: Int) {
        loading.value = true
        delay(1000)
        val recipe = recipeRepository.get(token = token, id = id)
        this.recipe.value = recipe
        loading.value = false
    }
}
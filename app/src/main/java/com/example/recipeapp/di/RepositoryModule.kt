package com.example.recipeapp.di

import com.example.recipeapp.network.RecipeService
import com.example.recipeapp.network.model.RecipeDto
import com.example.recipeapp.network.model.RecipeDtoMapper
import com.example.recipeapp.repository.RecipeRepository
import com.example.recipeapp.repository.RecipeRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository{
        return RecipeRepositoryImp(recipeService, recipeDtoMapper)
    }

}
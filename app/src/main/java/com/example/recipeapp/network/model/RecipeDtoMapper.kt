package com.example.recipeapp.network.model

import com.example.recipeapp.domain.model.Recipe
import com.example.recipeapp.domain.util.DomainMapper

class RecipeDtoMapper : DomainMapper <RecipeDto, Recipe> {

    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(
            id = model.pk,
            title = model.title,
            featuredImage = model.featuredImage,
            description = model.description,
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated,
            ingredients = model.ingredients ?: listOf(),
            publisher = model.publisher,
            rating = model.rating,
            sourceUrl = model.sourceUrl,
            cookingInstructions = model.cookingInstructions

        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            description = domainModel.description,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated,
            ingredients = domainModel.ingredients,
            publisher = domainModel.publisher,
            rating = domainModel.rating,
            sourceUrl = domainModel.sourceUrl,
            cookingInstructions = domainModel.cookingInstructions

        )
    }

    fun toDomainList(initial : List<RecipeDto>): List<Recipe> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial : List<Recipe>): List<RecipeDto> {
        return initial.map { mapFromDomainModel(it) }
    }

}
package com.culinarycompanion.repository

import com.example.culinarycompanion.model.RecipeSearchResponse
import com.example.culinarycompanion.network.RetrofitInstance
import retrofit2.Response

class RecipeRepository {
    suspend fun getRecipes(apiKey: String, query: String? = null, number: Int = 10): Response<RecipeSearchResponse> {
        return RetrofitInstance.apiService.getRecipes(apiKey, query, number)
    }
}

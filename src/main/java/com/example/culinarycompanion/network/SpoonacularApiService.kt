package com.example.culinarycompanion.network

import com.example.culinarycompanion.model.RecipeSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SpoonacularApiService {
    @GET("recipes/complexSearch")
    suspend fun searchRecipes(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String,
        @Query("number") number: Int = 10
    ): Response<RecipeSearchResponse>

    fun getRecipes(apiKey: String, query: String?, number: Int): Response<RecipeSearchResponse>
}

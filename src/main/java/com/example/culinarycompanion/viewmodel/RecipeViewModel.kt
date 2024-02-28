package com.example.culinarycompanion.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.culinarycompanion.Recipe
import com.example.culinarycompanion.network.RetrofitInstance
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {
    val recipesLiveData = MutableLiveData<List<Recipe>>()

    fun searchRecipes(query: String) {
        viewModelScope.launch {
            val response = RetrofitInstance.apiService.searchRecipes(apiKey = "https://api.spoonacular.com/recipes/", query = query)
            if (response.isSuccessful && response.body() != null) {
                recipesLiveData.postValue(response.body()!!.results)
            } else {
            }
        }
    }
}

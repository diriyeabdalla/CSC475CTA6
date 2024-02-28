package com.example.culinarycompanion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecipeFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_form2)

        val recipeNameEditText: EditText = findViewById(R.id.editTextRecipeName)
        val ingredientsEditText: EditText = findViewById(R.id.editTextRecipeIngredients)
        val stepsEditText: EditText = findViewById(R.id.editTextRecipeSteps)
        val submitButton: Button = findViewById(R.id.buttonSubmitRecipe)

        submitButton.setOnClickListener {
            val name = recipeNameEditText.text.toString()
            val ingredients = ingredientsEditText.text.toString()
            val steps = stepsEditText.text.toString()

            val recipe = Recipe(name, ingredients, steps)
            saveRecipe(recipe)
        }
    }

    private fun saveRecipe(recipe: Recipe) {
        val sharedPreferences = getSharedPreferences("recipes", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()

        val existingRecipesJson = sharedPreferences.getString("recipes_list", "[]")
        val type = object : TypeToken<List<Recipe>>() {}.type
        val recipesList: MutableList<Recipe> = gson.fromJson(existingRecipesJson, type)
        recipesList.add(recipe)

        val json = gson.toJson(recipesList)
        editor.putString("recipes_list", json)
        editor.apply()
    }
}

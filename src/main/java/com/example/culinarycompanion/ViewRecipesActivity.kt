package com.example.culinarycompanion

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ViewRecipesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_recipes)

        val listView: ListView = findViewById(R.id.listViewRecipes)
        val recipes = loadRecipes()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, recipes.map { it.name })
        listView.adapter = adapter
    }

    private fun loadRecipes(): List<Recipe> {
        val sharedPreferences = getSharedPreferences("recipes", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("recipes_list", "[]")
        val type = object : TypeToken<List<Recipe>>() {}.type
        return gson.fromJson(json, type)
    }
}

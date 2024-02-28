package com.example.culinarycompanion.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.culinarycompanion.R
import com.example.culinarycompanion.databinding.FragmentHomeBinding
import com.example.culinarycompanion.viewmodel.RecipeViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: RecipeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        binding.recipesRecyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.recipesLiveData.observe(viewLifecycleOwner) { recipes ->
        }

        binding.searchButton.setOnClickListener {
            viewModel.searchRecipes(binding.searchEditText.text.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.example.universityutils.features.food.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.room.Delete
import com.example.universityutils.databinding.FragmentFoodBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodFragment: Fragment() {

    private lateinit var foodViewModel : FoodViewModel
    private var _binding : FragmentFoodBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        val root : View = binding.root
        binding.btSearch.setOnClickListener {
            foodViewModel.searchFood(binding.etSearch.text.toString())
        }

        foodViewModel.food.observe(viewLifecycleOwner, {
            println("View has food now")
            println(it)
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
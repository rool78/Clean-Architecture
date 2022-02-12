package com.example.universityutils.features.food.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
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

        val textView : TextView = binding.textFood

        foodViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        print("Cuidao!")
        foodViewModel.searchFood()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
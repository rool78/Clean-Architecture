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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Delete
import com.example.universityutils.databinding.FragmentFoodBinding
import com.example.universityutils.features.food.presentation.adapter.FoodRecyclerViewAdapter
import com.example.universityutils.features.notes.presentation.notes.NoteRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodFragment: Fragment() {

    private lateinit var foodViewModel : FoodViewModel
    private var _binding : FragmentFoodBinding? = null

    private val binding get() = _binding!!

    private lateinit var mRecyclerView: RecyclerView

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
            mRecyclerView.adapter = FoodRecyclerViewAdapter(it.toMutableList())
        })
        mRecyclerView = binding.rvFood
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
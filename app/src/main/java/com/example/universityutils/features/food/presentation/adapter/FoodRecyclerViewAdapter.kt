package com.example.universityutils.features.food.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.universityutils.R
import com.example.universityutils.features.food.domain.model.Food
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso


class FoodRecyclerViewAdapter(
    private val foodList: MutableList<Food>,
) : RecyclerView.Adapter<FoodRecyclerViewAdapter.CustomViewHolder>() {

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        println("onBindViewHolder: ${foodList[position]}")
        val item = foodList[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.food_card_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = foodList.size

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(food: Food) {
            println("viewHolder bind -> $food")
            itemView.findViewById<MaterialCardView>(R.id.food_card).setOnClickListener {
                println("#### food card clicked...$it")
            }
            val image = itemView.findViewById<ImageView>(R.id.food_image)
            Picasso.get().load(food.imageUrl).into(image)
            itemView.findViewById<MaterialTextView>(R.id.tv_food_name).text = food.name
            itemView.findViewById<MaterialTextView>(R.id.tv_food_calories).text =
                food.caloriesPer100g.toString()
        }
    }
}
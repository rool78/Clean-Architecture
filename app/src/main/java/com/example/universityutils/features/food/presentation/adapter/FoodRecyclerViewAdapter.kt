package com.example.universityutils.features.food.presentation.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.universityutils.R
import com.example.universityutils.features.food.domain.model.Food
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

class FoodRecyclerViewAdapter(
    private val foodList: MutableList<Food>,
    private val context: Context
) :
    RecyclerView.Adapter<FoodRecyclerViewAdapter.CustomViewHolder>() {

    fun removeNote(food: Food) {
        val index = foodList.indexOf(food)
        if (index != -1) {
            foodList.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        println("onBindViewHolder: ${foodList[position]}")
        val item = foodList[position]
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.note_card_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = foodList.size

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(food: Food, context: Context) {
            println("viewHolder bind -> $food")
            itemView.findViewById<MaterialCardView>(R.id.note_card).setOnClickListener {
                println("view Note")
            }
            if (food.imageUrl != null) {
//                itemView.findViewById<Material>(R.id.food_image).setImageURI(Uri.parse(food.imageUrl))
            }
            itemView.findViewById<MaterialTextView>(R.id.tv_food_name).text = food.name
            itemView.findViewById<MaterialTextView>(R.id.tv_food_calories).text = food.caloriesPer100g.toString()

            //TODO date
//            itemView.findViewById<MaterialButton>(R.id.remove_post_button).setOnClickListener {
//                removePost(note)
//                Toast.makeText(context, "Removing note", Toast.LENGTH_SHORT).show()
//            }
//            itemView.findViewById<MaterialButton>(R.id.edit_note_button).setOnClickListener {
//                Toast.makeText(context, "Edit note", Toast.LENGTH_SHORT).show()
//            }
        }
    }
}
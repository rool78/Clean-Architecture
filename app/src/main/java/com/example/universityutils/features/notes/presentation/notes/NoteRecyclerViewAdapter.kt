package com.example.universityutils.features.notes.presentation.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.universityutils.R
import com.example.universityutils.features.notes.domain.model.Note
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class NoteRecyclerViewAdapter(
    private val notes: MutableList<Note>,
    private val context: Context
) :
    RecyclerView.Adapter<NoteRecyclerViewAdapter.CustomViewHolder>() {

    fun removeNote(note: Note) {
        val index = notes.indexOf(note)
        if (index != -1) {
            notes.remove(note)
            notifyItemRemoved(index)
        }
    }

    fun editNote() {
        TODO("later")
    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        println("onBindViewHolder: ${notes[position]}")
        val item = notes[position]
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

    override fun getItemCount(): Int = notes.size


    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(note: Note, context: Context) {
            println("viewHolder bind -> $note")
            itemView.findViewById<MaterialTextView>(R.id.title_note_value).text = note.title
            itemView.findViewById<MaterialTextView>(R.id.body_note_value).text = note.text
            //TODO date
            itemView.findViewById<MaterialButton>(R.id.remove_post_button).setOnClickListener {
//                removePost(note)
                Toast.makeText(context, "Removing note", Toast.LENGTH_SHORT).show()
            }
            itemView.findViewById<MaterialButton>(R.id.edit_note_button).setOnClickListener {
                Toast.makeText(context, "Edit note", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
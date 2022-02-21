package com.example.universityutils.features.notes.presentation.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.universityutils.R
import com.example.universityutils.databinding.FragmentNotesBinding
import com.example.universityutils.features.notes.domain.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped

@AndroidEntryPoint
class NotesFragment : Fragment() {

    private lateinit var notesViewModel: NotesViewModel
    private var _binding: FragmentNotesBinding? = null

    private lateinit var mRecyclerView: RecyclerView
//    ......
    private var notes = mutableListOf<Note>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotes
        notesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        //pasamos a recyclerview directamente el livedata
        notesViewModel.notesModel.observe(viewLifecycleOwner, Observer {
            println("notes observer $it")
            notes = it.toMutableList()
            mRecyclerView.adapter = context?.let { it1 -> NoteRecyclerViewAdapter(notes, it1) }
        })

        notesViewModel.getNotes()

        val floatingActionButton = requireActivity().findViewById<FloatingActionButton>(R.id.floatingActionButton)
        val res = context?.let { ContextCompat.getDrawable(it, R.drawable.ic_add) }
        floatingActionButton.setImageDrawable(res)
        floatingActionButton.show()
        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_notes_to_navigation_edit_notes)
        }

        mRecyclerView = binding.rvMain
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
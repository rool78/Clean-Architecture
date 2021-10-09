package com.example.universityutils.features.notes.presentation.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.universityutils.R
import com.example.universityutils.databinding.FragmentNotesBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NotesFragment : Fragment() {

    private lateinit var notesViewModel: NotesViewModel
    private var _binding: FragmentNotesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notesViewModel =
            ViewModelProvider(this).get(NotesViewModel::class.java)

        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotes
        notesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        val floatingActionButton = requireActivity().findViewById<FloatingActionButton>(R.id.floatingActionButton)

        floatingActionButton.show()

        floatingActionButton.setOnClickListener {
            println("floating action button")
            findNavController().navigate(R.id.action_navigation_notes_to_navigation_edit_notes)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.universityutils.features.notes.presentation.edit_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.universityutils.R
import com.example.universityutils.databinding.FragmentEditNotesBinding
import com.example.universityutils.features.notes.domain.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped

@AndroidEntryPoint
class EditNoteFragment : Fragment() {

    private var _binding: FragmentEditNotesBinding? = null
    private val editNoteViewModel: EditNoteViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        editNoteViewModel = ViewModelProvider(this).get(EditNoteViewModel::class.java)

        _binding = FragmentEditNotesBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            println("Button pressed ${binding.etText.text}")
            editNoteViewModel
                .addNote(Note(0, binding.etTitle.text.toString(), binding.etText.text.toString(),
                    System.currentTimeMillis()))

            editNoteViewModel.getNotes()
        }

        //TODO gestion fab
        val fab = activity?.findViewById<FloatingActionButton>(R.id.floatingActionButton)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
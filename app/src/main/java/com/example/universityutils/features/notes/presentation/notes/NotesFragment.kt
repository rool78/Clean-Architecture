package com.example.universityutils.features.notes.presentation.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.universityutils.R
import com.example.universityutils.databinding.FragmentNotesBinding
import com.example.universityutils.features.notes.presentation.components.NoteItem
import com.google.accompanist.appcompattheme.AppCompatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : Fragment() {

    private lateinit var notesViewModel: NotesViewModel
    private var _binding: FragmentNotesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        notesViewModel.getNotes()

        val floatingActionButton = binding.fabAddNote
        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_notes_to_navigation_edit_notes)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lazyList.setContent {
            AppCompatTheme {
                NoteScreen()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @Composable
    private fun NoteScreen() {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(notesViewModel.state.value.notes) { note ->
                NoteItem(
                    note = note,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            println("#### note click")
                        }
                        .padding(6.dp),
                    onDeleteClick = {
                        println("#### delete click")
                    }
                )
            }
        }
    }
}
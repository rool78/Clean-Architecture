package com.example.universityutils.features.notes.presentation.edit_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.universityutils.databinding.FragmentEditNotesBinding

class EditNoteFragment : Fragment() {

    private var _binding: FragmentEditNotesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEditNotesBinding.inflate(inflater, container, false)


        binding.button.setOnClickListener {
            println("Button pressed ${binding.editText.text}")
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
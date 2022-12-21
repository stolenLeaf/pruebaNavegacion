package com.example.pruebanavegacion.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.pruebanavegacion.R
import com.example.pruebanavegacion.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {
private lateinit var binding: FragmentGameWonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentGameWonBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.nextMatchButton.setOnClickListener { v:View->
            Navigation.findNavController(v).navigate(R.id.action_gameWonFragment_to_gameFragment)
        }
    }
}
package com.example.pruebanavegacion.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.pruebanavegacion.databinding.FragmentGameOverBinding


class GameOverFragment : Fragment() {
private lateinit var binding: FragmentGameOverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGameOverBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tryAgainButton.setOnClickListener{v:View ->
            Navigation.findNavController(v)
                .navigate(GameOverFragmentDirections
                    .actionGameOverFragment2ToGameFragment())
        }
    }

}
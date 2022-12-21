package com.example.pruebanavegacion.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import com.example.pruebanavegacion.R
import com.example.pruebanavegacion.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {
private lateinit var binding :FragmentTitleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
    binding=FragmentTitleBinding.inflate(inflater,container,false)
        val view=binding.root
        return view

//        return inflater.inflate(R.layout.fragment_title, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            binding.playButton.setOnClickListener {v:View ->
            Navigation.findNavController(v).navigate(R.id.action_titleFragment_to_gameFragment)

        }
    }

}
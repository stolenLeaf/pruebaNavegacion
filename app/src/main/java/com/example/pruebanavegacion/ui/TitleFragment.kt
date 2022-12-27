package com.example.pruebanavegacion.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pruebanavegacion.R
import com.example.pruebanavegacion.databinding.FragmentTitleBinding


@Suppress("DEPRECATION")
class TitleFragment : Fragment() {
private lateinit var binding :FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
    binding=FragmentTitleBinding.inflate(inflater,container,false)
        val view=binding.root
        (activity as AppCompatActivity).supportActionBar?.title =getString(R.string.android_trivia)
        setHasOptionsMenu(true)
        return view

//        return inflater.inflate(R.layout.fragment_title, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            binding.playButton.setOnClickListener {v:View ->
            Navigation.findNavController(v).navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())



        }
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}
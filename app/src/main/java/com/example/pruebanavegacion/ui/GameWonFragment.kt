package com.example.pruebanavegacion.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.pruebanavegacion.R
import com.example.pruebanavegacion.databinding.FragmentGameWonBinding

@Suppress("DEPRECATION")
class GameWonFragment : Fragment() {
private lateinit var binding: FragmentGameWonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentGameWonBinding.inflate(inflater, container, false)
        val view = binding.root
        val args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        Toast.makeText(context,
            "NumCorrect: ${args?.numCorrect}," +
                    " numQuestions: ${args?.numQuestions}",
            Toast.LENGTH_SHORT).show()
        setHasOptionsMenu(true)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.nextMatchButton.setOnClickListener { v:View->
            Navigation.findNavController(v)
                .navigate(GameWonFragmentDirections
                    .actionGameWonFragmentToGameFragment())
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        //chequea si el activity responde
        if (null==getShareIntent().resolveActivity(requireActivity().packageManager))
        {
            //hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.isVisible = false
        }
    }

    @Deprecated("Deprecated in Java", ReplaceWith(
        "super.onOptionsItemSelected(item)",
        "androidx.fragment.app.Fragment"
    )
    )
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share->shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
    private fun getShareIntent(): Intent {
        val args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT,getString(
            R.string.share_success_text,
            args?.numCorrect,
            args?.numQuestions))
        return shareIntent
    }

}
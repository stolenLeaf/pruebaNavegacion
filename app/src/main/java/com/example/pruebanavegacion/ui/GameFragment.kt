package com.example.pruebanavegacion.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.pruebanavegacion.R
import com.example.pruebanavegacion.data.model.Question
import com.example.pruebanavegacion.databinding.FragmentGameBinding
import kotlin.math.min


class GameFragment : Fragment() {
    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack?",
            answers = listOf("all of these", "tools", "documentation", "libraries")
        ),
        Question(
            text = "Base class for Layout?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
        ),
        Question(
            text = "Layout for complex Screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
        ),
        Question(
            text = "Pushing structured data into a Layout?",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")
        ),
        Question(
            text = "Inflate layout in fragments?",
            answers = listOf("onCreateView", "onViewCreated", "onCreateLayout", "onInflateLayout")
        ),
        Question(
            text = "Build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
        ),
        Question(
            text = "Android vector format?",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector"
            )
        ),
        Question(
            text = "Android Navigation Component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
        ),
        Question(
            text = "Registers app with launcher?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
        ),
        Question(
            text = "Mark a layout for Data Binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
        )
    )
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = min((questions.size + 1) / 2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil
            .inflate<FragmentGameBinding>(inflater,
                R.layout.fragment_game,
                container,false)
        randomizeQuestion()
    binding.game=this
    binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){
    v: View ->
    val checkedId=binding.questionRadioGroup.checkedRadioButtonId
    if(-1!=checkedId){
        var answerIndex=0
        when(checkedId){
            R.id.secondAnswerRadioButton->answerIndex=1
            R.id.thirdAnswerRadioButton->answerIndex=2
            R.id.fourthAnswerRadioButton->answerIndex=3
        }
    if(answers[answerIndex]==currentQuestion.answers[0]){
        questionIndex++
        if(questionIndex<numQuestions){
            currentQuestion=questions[questionIndex]
            setQuestion()
            binding.invalidateAll()
        }else{
            //ganamos, vamos al fragment de navegacion
            v.findNavController().navigate(GameFragmentDirections
                .actionGameFragmentToGameWonFragment(numQuestions, questionIndex ))
        }
    }else{
        //perdimos, vamos al fragment de game over
        v.findNavController().navigate(GameFragmentDirections
            .actionGameFragmentToGameOverFragment2())
    }
    }
}
        return binding.root
    }

    private fun randomizeQuestion() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.
        title = getString(R.string.title_android_trivia_question,
            questionIndex + 1, numQuestions)

    }
}
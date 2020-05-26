package com.sunasterisk.a14day_challenge.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sunasterisk.a14day_challenge.R
import com.sunasterisk.a14day_challenge.ui.plank.PlankFragment
import com.sunasterisk.a14day_challenge.ui.pushUp.PushUpFragment
import com.sunasterisk.a14day_challenge.ui.run.RunFragment
import kotlinx.android.synthetic.main.activity_exercise.*

class ExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val typeExercise = intent.getStringExtra(EXTRA_TYPE_EXERCISE) ?: return
        textExerciseTitle.text = typeExercise
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_exercise_container, getFragment(typeExercise))
            .commit()
    }

    private fun getFragment(typeExercise: String) : Fragment{
        var fragment : Fragment = PushUpFragment.newInstance()
        when (typeExercise) {
            getString(R.string.title_run_exercise) -> {
                fragment = RunFragment.newInstance()
            }
            getString(R.string.title_plank_exercise) -> {
                fragment = PlankFragment.newInstance()
            }
        }
        return fragment
    }

    companion object {
        private const val EXTRA_TYPE_EXERCISE = "EXTRA_TYPE_EXERCISE"

        fun getIntent(context: Context, type: String) =
            Intent(context, ExerciseActivity::class.java).apply {
                putExtra(EXTRA_TYPE_EXERCISE, type)
            }
    }
}

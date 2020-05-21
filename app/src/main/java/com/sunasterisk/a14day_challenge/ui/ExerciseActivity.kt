package com.sunasterisk.a14day_challenge.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunasterisk.a14day_challenge.R

class ExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
    }

    companion object {
        private const val EXTRA_TYPE_EXERCISE = "EXTRA_TYPE_EXERCISE"

        fun getIntent(context: Context, type: String) =
            Intent(context, ExerciseActivity::class.java).apply {
                putExtra(EXTRA_TYPE_EXERCISE, type)
            }
    }
}

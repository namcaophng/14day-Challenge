package com.sunasterisk.a14day_challenge.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunasterisk.a14day_challenge.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    companion object {
        const val ACCOUNT = "account"
        const val NAME = "name"
        const val PROCESS = "process"
        const val PROCESS_DEFAULT = 1

        fun getHomeIntent(context: Context, username: String, name: String): Intent {
            return Intent(context, HomeActivity::class.java).apply {
                putExtra(ACCOUNT, username)
                putExtra(NAME, name)
                putExtra(PROCESS, PROCESS_DEFAULT)
            }
        }
    }
}

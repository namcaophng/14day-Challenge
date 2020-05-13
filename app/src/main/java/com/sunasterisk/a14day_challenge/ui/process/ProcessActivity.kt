package com.sunasterisk.a14day_challenge.ui.process

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunasterisk.a14day_challenge.R

class ProcessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process)
    }

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, ProcessActivity::class.java)
    }
}

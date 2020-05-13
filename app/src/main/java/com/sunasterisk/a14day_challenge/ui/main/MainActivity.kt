package com.sunasterisk.a14day_challenge.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunasterisk.a14day_challenge.R
import com.sunasterisk.a14day_challenge.data.UserRepository
import com.sunasterisk.a14day_challenge.data.local.DataBaseHandler
import com.sunasterisk.a14day_challenge.data.local.UserLocalDataSource
import com.sunasterisk.a14day_challenge.data.local.dao.UserDAOImp
import com.sunasterisk.a14day_challenge.data.model.User
import com.sunasterisk.a14day_challenge.ui.ContextExtensions.Companion.showToast
import com.sunasterisk.a14day_challenge.ui.home.HomeFragment

class MainActivity : AppCompatActivity(), MainContract.View {

    private val sharedPreferences by lazy { getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE) }
    private val presenter by lazy { MainPresenter(this, userRepository) }
    private val userRepository =
        UserRepository.getInstance(UserLocalDataSource.getInstance(UserDAOImp.getInstance(DataBaseHandler.getInstance(this), sharedPreferences)))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveUserInSharePref()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, HomeFragment())
            .commit()
    }

    private fun saveUserInSharePref() {
        intent?.let {
            val extraFrom = it.getStringExtra(EXTRA_FROM)
            if (extraFrom != null) {
                if (extraFrom.contentEquals(LOGIN_SCREEN)) {
                    presenter.saveUserInSharedPref(
                        it.getStringExtra(EXTRA_ACCOUNT),
                        it.getStringExtra(EXTRA_NAME),
                        it.getIntExtra(EXTRA_PROCESS, PROCESS_DEFAULT)
                    )
                }
            }
        }
    }

    override fun showToastError(error: String) {
        showToast(error)
    }

    companion object {
        private const val LOGIN_SCREEN = "login_screen"
        private const val EXTRA_FROM = "from"
        private const val EXTRA_ACCOUNT = "account"
        private const val EXTRA_NAME = "name"
        private const val EXTRA_PROCESS = "process"
        private const val PROCESS_DEFAULT = 1
        private const val PREF_FILE = "PREF_FILE"

        fun getIntent(context: Context, user: User): Intent =
            Intent(context, MainActivity::class.java)
                .putExtra(EXTRA_FROM, LOGIN_SCREEN)
                .putExtra(EXTRA_ACCOUNT, user.account)
                .putExtra(EXTRA_NAME, user.name)
                .putExtra(EXTRA_PROCESS, user.process)

    }
}

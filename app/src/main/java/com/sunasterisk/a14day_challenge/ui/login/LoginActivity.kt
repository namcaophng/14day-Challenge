package com.sunasterisk.a14day_challenge.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sunasterisk.a14day_challenge.R
import com.sunasterisk.a14day_challenge.data.UserRepository
import com.sunasterisk.a14day_challenge.data.local.DataBaseHandler
import com.sunasterisk.a14day_challenge.data.local.UserLocalDataSource
import com.sunasterisk.a14day_challenge.data.local.dao.UserDAOImp
import com.sunasterisk.a14day_challenge.data.model.User
import com.sunasterisk.a14day_challenge.ui.ContextExtensions.Companion.showToast
import com.sunasterisk.a14day_challenge.ui.MainActivity
import com.sunasterisk.a14day_challenge.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener,
    LoginContract.View {

    private val userRepository = UserRepository(UserLocalDataSource(UserDAOImp(DataBaseHandler(this))))
    private val presenter by lazy { LoginPresenter(this, userRepository) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        registerListeners()
    }

    private fun registerListeners() {
        buttonSignUp.setOnClickListener(this)
        buttonSignIn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonSignIn -> handleLogin()
            R.id.buttonSignUp -> moveToSignUpScreen()
        }
    }

    private fun moveToSignUpScreen() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    private fun handleLogin() {
        presenter.handleLogin(
            editAccount.text.toString(),
            editPassword.text.toString()
        )
    }

    override fun changeToHomeScreen(user: User) {
        startActivity(MainActivity.getIntent(this).apply {
            putExtra(ACCOUNT, user.account)
            putExtra(NAME, user.name)
            putExtra(PROCESS, user.process)
        })
    }

    override fun showErrorLogin(error: String) {
        showToast(error)
    }

    companion object {
        const val ACCOUNT = "account"
        const val NAME = "name"
        const val PROCESS = "process"
        fun getIntent(context: Context) =  Intent(context, LoginActivity::class.java)
    }
}

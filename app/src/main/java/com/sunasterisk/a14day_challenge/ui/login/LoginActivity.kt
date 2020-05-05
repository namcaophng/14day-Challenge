package com.sunasterisk.a14day_challenge.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sunasterisk.a14day_challenge.R
import com.sunasterisk.a14day_challenge.data.UserRepository
import com.sunasterisk.a14day_challenge.data.local.DataBaseHandler
import com.sunasterisk.a14day_challenge.data.local.UserLocalDataSource
import com.sunasterisk.a14day_challenge.data.local.dao.UserDaoImp
import com.sunasterisk.a14day_challenge.data.model.User
import com.sunasterisk.a14day_challenge.ui.home.HomeActivity
import com.sunasterisk.a14day_challenge.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener,
    LoginContract.View {

    lateinit var presenter: LoginPresenter
    lateinit var userRepository: UserRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userRepository = UserRepository(UserLocalDataSource(UserDaoImp(DataBaseHandler(this))))
        registerListeners()
        presenter = LoginPresenter(this)
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
            userRepository,
            editAccount.text.toString(),
            editPassword.text.toString()
        )
    }

    override fun onLoginSucceeded(user: User) {
        startActivity(Intent(this, HomeActivity::class.java).apply {
            putExtra(ACCOUNT, user.account)
            putExtra(NAME, user.name)
            putExtra(PROCESS, user.process)
        })
    }

    override fun onLoginFailure(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val ACCOUNT = "account"
        const val NAME = "name"
        const val PROCESS = "process"
        fun getIntent(context: Context) =  Intent(context, LoginActivity::class.java)
    }
}

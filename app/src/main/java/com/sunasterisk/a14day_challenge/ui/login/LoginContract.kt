package com.sunasterisk.a14day_challenge.ui.login

import com.sunasterisk.a14day_challenge.data.UserRepository
import com.sunasterisk.a14day_challenge.data.model.User

interface LoginContract {
    interface View{
        fun onLoginSucceeded(user: User)

        fun onLoginFailure(error: String)
    }

    interface Presenter{
        fun handleLogin(userRepository: UserRepository, account: String, password: String)
    }
}

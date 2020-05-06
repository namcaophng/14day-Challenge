package com.sunasterisk.a14day_challenge.data

import com.sunasterisk.a14day_challenge.data.local.UserLocalDataSource
import com.sunasterisk.a14day_challenge.data.model.User

class UserRepository(private var userLocalDataSource: UserLocalDataSource) :
    UserDataSource.Local {
    override fun getAllUsers(): List<User>? {
        return userLocalDataSource.getAllUsers()
    }
}

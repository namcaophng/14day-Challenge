package com.sunasterisk.a14day_challenge.data.local

import com.sunasterisk.a14day_challenge.data.UserDataSource
import com.sunasterisk.a14day_challenge.data.local.dao.UserDAO
import com.sunasterisk.a14day_challenge.data.model.User

class UserLocalDataSource(private var userDAO: UserDAO) : UserDataSource.Local {
    override fun getAllUsers(): List<User>? {
        return userDAO.getAllUsers()
    }
}

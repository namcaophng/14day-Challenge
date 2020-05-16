package com.sunasterisk.a14day_challenge.data.local

import com.sunasterisk.a14day_challenge.data.UserDataSource
import com.sunasterisk.a14day_challenge.data.local.dao.UserDAO
import com.sunasterisk.a14day_challenge.data.model.User

class UserLocalDataSource private constructor(private val userDAO: UserDAO) : UserDataSource.Local {
    override fun editUserOnSharedPref(name: String) {
        userDAO.editUserOnSharedPref(name)
    }

    override fun updateUser(user: User?, callback: OnLoadedDataCallback<Boolean?>) {
        userDAO.updateUser(user, callback)
    }

    override fun getCurrentUser(): User? {
        return userDAO.getCurrentUser()
    }

    override fun saveUserOnSharedPref(account: String, name: String, process: Int) {
        userDAO.saveUserOnSharedPref(account, name, process)
    }

    override fun addUser(user: User, callback: OnLoadedDataCallback<Boolean?>) {
        userDAO.addUser(user, callback)
    }

    override fun getAllUsers(): List<User>? {
        return userDAO.getAllUsers()
    }

    companion object {
        private var instance: UserLocalDataSource? = null
        fun getInstance(userDAO: UserDAO) =
            instance ?: UserLocalDataSource(userDAO).also { instance = it }
    }
}

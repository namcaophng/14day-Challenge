package com.sunasterisk.a14day_challenge.data

import com.sunasterisk.a14day_challenge.data.local.OnLoadedDataCallback
import com.sunasterisk.a14day_challenge.data.model.User

class UserRepository private constructor(
    private val local: UserDataSource.Local
) : UserDataSource.Local {
    override fun editUserOnSharedPref(name: String) {
        local.editUserOnSharedPref(name)
    }

    override fun updateUser(user: User?, callback: OnLoadedDataCallback<Boolean?>) {
        local.updateUser(user, callback)
    }

    override fun getCurrentUser(): User? {
        return local.getCurrentUser()
    }

    override fun saveUserOnSharedPref(account: String, name: String, process: Int) {
        local.saveUserOnSharedPref(account, name, process)
    }

    override fun addUser(user: User, callback: OnLoadedDataCallback<Boolean?>) {
        local.addUser(user, callback)
    }

    override fun getAllUsers(): List<User>? {
        return local.getAllUsers()
    }

    companion object {
        private var instance: UserRepository? = null
        fun getInstance(local: UserDataSource.Local) =
            instance ?: UserRepository(local).also { instance = it }
    }
}

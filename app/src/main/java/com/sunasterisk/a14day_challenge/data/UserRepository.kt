package com.sunasterisk.a14day_challenge.data

import com.sunasterisk.a14day_challenge.data.local.OnLoadedDataCallback
import com.sunasterisk.a14day_challenge.data.model.User

class UserRepository private constructor(
    private val local: UserDataSource.Local
) : UserDataSource.Local {
    override fun saveUser(account: String, name: String, process: Int) {
        local.saveUser(account, name, process)
    }

    override fun addUser(user: User, callback: OnLoadedDataCallback<Boolean>) {
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

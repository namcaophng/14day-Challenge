package com.sunasterisk.a14day_challenge.data

import com.sunasterisk.a14day_challenge.data.local.OnLoadedDataCallback
import com.sunasterisk.a14day_challenge.data.model.User

class UserRepository(
    private var local: UserDataSource.Local
) : UserDataSource.Local {
    override fun addUser(user: User, callback: OnLoadedDataCallback<Boolean>) {
        local.addUser(user, callback)
    }

    override fun getAllUsers(): List<User>? {
        return local.getAllUsers()
    }
}

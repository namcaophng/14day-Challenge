package com.sunasterisk.a14day_challenge.data

import com.sunasterisk.a14day_challenge.data.local.OnLoadedDataCallback
import com.sunasterisk.a14day_challenge.data.model.User

interface UserDataSource {
    interface Local {
        fun getAllUsers(): List<User>?

        fun addUser(user: User, callback: OnLoadedDataCallback<Boolean>)
    }
}

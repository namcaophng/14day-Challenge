package com.sunasterisk.a14day_challenge.data.local.dao

import com.sunasterisk.a14day_challenge.data.local.OnLoadedDataCallback
import com.sunasterisk.a14day_challenge.data.model.User

interface UserDAO {
    fun getAllUsers(): List<User>?

    fun addUser(user: User, callback: OnLoadedDataCallback<Boolean?>)

    fun saveUserOnSharedPref(account: String, name: String, process: Int)

    fun getCurrentUser(): User?

    fun updateUser(user: User?, callback: OnLoadedDataCallback<Boolean?>)

    fun editUserOnSharedPref(name: String)
}

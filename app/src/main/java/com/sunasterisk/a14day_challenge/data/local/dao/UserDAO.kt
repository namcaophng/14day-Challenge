package com.sunasterisk.a14day_challenge.data.local.dao

import com.sunasterisk.a14day_challenge.data.model.User

interface UserDAO {
    fun getAllUsers(): List<User>?
}

package com.sunasterisk.a14day_challenge.data.local.dao

import com.sunasterisk.a14day_challenge.data.local.DataBaseHandler
import com.sunasterisk.a14day_challenge.data.model.User

class UserDaoImp(private var db: DataBaseHandler?) : UserDAO {
    override fun getAllUsers(): List<User>? {
        return db?.getUserAll()
    }
}

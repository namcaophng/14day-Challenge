package com.sunasterisk.a14day_challenge.data.local.dao

import com.sunasterisk.a14day_challenge.data.local.DataBaseHandler
import com.sunasterisk.a14day_challenge.data.local.LoadDataAsync
import com.sunasterisk.a14day_challenge.data.local.OnLoadedDataCallback
import com.sunasterisk.a14day_challenge.data.model.User

class UserDAOImp(private var db: DataBaseHandler?) : UserDAO {

    override fun getAllUsers(): List<User>? {
        return db?.getUserAll()
    }

    override fun addUser(user: User, callback: OnLoadedDataCallback<Boolean>) {
        LoadDataAsync(callback).execute(db?.addUser(user))
    }
}

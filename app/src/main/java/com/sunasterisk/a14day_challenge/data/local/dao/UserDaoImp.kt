package com.sunasterisk.a14day_challenge.data.local.dao

import android.content.SharedPreferences
import com.sunasterisk.a14day_challenge.data.local.DataBaseHandler
import com.sunasterisk.a14day_challenge.data.local.LoadDataAsync
import com.sunasterisk.a14day_challenge.data.local.OnLoadedDataCallback
import com.sunasterisk.a14day_challenge.data.model.User

class UserDAOImp private constructor(
    private val db: DataBaseHandler?,
    private val sharedPreferences: SharedPreferences
) : UserDAO {
    override fun editUserOnSharedPref(name: String) {
        sharedPreferences.edit().apply {
            putString(PREF_NAME, name)
            apply()
        }
    }

    override fun getCurrentUser(): User? {
        val account = sharedPreferences.getString(PREF_ACCOUNT, null)
        return account?.let {
            db?.getCurrentUser(it)
        }
    }

    override fun updateUser(user: User?, callback: OnLoadedDataCallback<Boolean?>) {
        LoadDataAsync<User, Boolean?>(callback){
            db?.updateUser(user)
        }.execute(user)
    }

    override fun getAllUsers(): List<User>? {
        return db?.getUserAll()
    }

    override fun addUser(user: User, callback: OnLoadedDataCallback<Boolean?>) {
        LoadDataAsync<User, Boolean?>(callback) {
            db?.addUser(user)
        }.execute(user)
    }

    override fun saveUserOnSharedPref(
        account: String,
        name: String,
        process: Int
    ) {
        sharedPreferences.edit().apply {
            putString(PREF_ACCOUNT, account)
            putString(PREF_NAME, name)
            putInt(PREF_PROCESS, process)
            apply()
        }
    }

    companion object {
        private const val PREF_ACCOUNT = "pref_account"
        private const val PREF_NAME = "pref_name"
        private const val PREF_PROCESS = "pref_process"

        private var instance: UserDAOImp? = null

        fun getInstance(db: DataBaseHandler?, sharedPreferences: SharedPreferences) =
            instance ?: UserDAOImp(db, sharedPreferences).also { instance = it }
    }
}

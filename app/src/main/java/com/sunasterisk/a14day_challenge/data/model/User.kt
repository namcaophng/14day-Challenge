package com.sunasterisk.a14day_challenge.data.model

import android.content.ContentValues
import android.database.Cursor

data class User(
    val account: String,
    var name: String,
    var password: String,
    val birthday: String,
    var height: String,
    var weight: String,
    var process: Int
) {
    constructor(cursor: Cursor) : this(
        cursor.getString(cursor.getColumnIndex(USER_ACC)),
        cursor.getString(cursor.getColumnIndex(USER_NAME)),
        cursor.getString(cursor.getColumnIndex(USER_PASS)),
        cursor.getString(cursor.getColumnIndex(USER_BIR)),
        cursor.getString(cursor.getColumnIndex(USER_HEIGHT)),
        cursor.getString(cursor.getColumnIndex(USER_WEIGHT)),
        cursor.getInt(cursor.getColumnIndex(USER_PROCESS))
    )

    companion object {
        private const val USER_ACC = "account"
        private const val USER_NAME = "name"
        private const val USER_PASS = "password"
        private const val USER_BIR = "birthday"
        private const val USER_HEIGHT = "height"
        private const val USER_WEIGHT = "weight"
        private const val USER_PROCESS = "process"
        fun getContentValues(user: User) = ContentValues().apply {
            put(USER_ACC, user.account)
            put(USER_NAME, user.name)
            put(USER_PASS, user.password)
            put(USER_BIR, user.birthday)
            put(USER_HEIGHT, user.height)
            put(USER_WEIGHT, user.weight)
            put(USER_PROCESS, user.process)
        }
    }
}

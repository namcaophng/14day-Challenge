package com.sunasterisk.a14day_challenge.data.local

import android.content.res.Resources
import android.os.AsyncTask
import com.sunasterisk.a14day_challenge.R

class LoadDataAsync<T>(private val callback: OnLoadedDataCallback<T>) : AsyncTask<T, Void, T?>() {
    override fun doInBackground(vararg params: T): T? {
        return params[0]
    }

    override fun onPostExecute(result: T?) {
        if (result == true) {
            callback.onSuccessful(result)
        } else {
            callback.onFailed(Resources.getSystem().getString(R.string.error_load_data))
        }
    }
}

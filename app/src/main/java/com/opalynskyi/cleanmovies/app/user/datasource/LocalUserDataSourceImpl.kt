package com.opalynskyi.cleanmovies.app.user.datasource

import android.content.SharedPreferences
import com.google.gson.Gson
import com.opalynskyi.cleanmovies.app.toJson
import com.opalynskyi.cleanmovies.core.data.user.LocalUserDataSource
import com.opalynskyi.cleanmovies.core.data.user.User
import timber.log.Timber

class LocalUserDataSourceImpl(private val sharedPreferences: SharedPreferences, private val gson: Gson) :
    LocalUserDataSource {
    override var currentUser: User?
        get() {
            val userJson = sharedPreferences.getString(PREF_CURRENT_USER, "")
            var user: User? = null
            try {
                user = gson.fromJson(userJson, User::class.java)
            } catch (ex: Exception) {
                Timber.d("Can not retrieve user from local storage: ${ex.message}")
            }
            return user
        }
        set(user) {
            sharedPreferences.edit().putString(user?.toJson(), "").apply()
        }

    override fun clearCurrentUser() {
        sharedPreferences.edit().putString(PREF_CURRENT_USER, "").apply()
    }

    companion object {
        private const val PREF_CURRENT_USER = "pref_current_user"
    }
}
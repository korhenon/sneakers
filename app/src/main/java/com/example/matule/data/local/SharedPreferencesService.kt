package com.example.matule.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesService @Inject constructor(
    @ApplicationContext context: Context
) {
    private val sp = context.getSharedPreferences("APP_SP", Context.MODE_PRIVATE)

    var lastPageVisit: Int
        get() = sp.getInt("lastPageVisit", 1)
        set(value) = sp.edit().putInt("lastPageVisit", value).apply()
}
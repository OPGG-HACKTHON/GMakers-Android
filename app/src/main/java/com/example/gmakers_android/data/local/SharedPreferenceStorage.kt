package com.example.gmakers_android.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.gmakers_android.MainApplication

object SharedPreferenceStorage{
    private var pref: SharedPreferences? = null
    private val context = MainApplication.context()

    fun getInfo(content: String?): String{
        if(pref == null)pref = context.getSharedPreferences(content, Context.MODE_PRIVATE)
        return if (content == "access_token"){
            "Bearer " + pref!!.getString(content,"")
        } else
            pref!!.getString(content, "").toString()
    }

    fun saveInfo(info: String, content: String){
        if(pref == null) pref = context.getSharedPreferences(content, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = pref!!.edit()
        editor.putString(content,info)
        editor.apply()
    }

    fun clearToken(content: String){
        if(pref == null) pref = context.getSharedPreferences(content, Context.MODE_PRIVATE)
        pref!!.edit().remove(content).apply()
    }
}
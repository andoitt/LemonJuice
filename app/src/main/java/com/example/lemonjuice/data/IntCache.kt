package com.example.lemonjuice.data

import android.content.SharedPreferences

interface IntCache {

    fun save(value: Int)

    fun read() : Int

    class Base(
        private val key : String,
        private val permanentStorage: PermanentStorage,
        private val default : Int,
    ) : IntCache {

        override fun save(value: Int) {
            permanentStorage.save(value, key)
        }

        override fun read(): Int {
            return permanentStorage.read(key, default)
        }
    }
}

interface PermanentStorage {
    fun save (value: Int, key: String)
    fun save (value:String, key: String)
    fun read(key: String, default: Int): Int
    fun read(key: String, default: String): String

    class Base (
        private val sharedPreferences: SharedPreferences
    ) : PermanentStorage {
        override fun save(value: Int, key: String) {
            sharedPreferences.edit().putInt(key,value).apply()
        }

        override fun save(value: String, key: String) {
            sharedPreferences.edit().putString(key,value).apply()
        }

        override fun read(key: String, default: Int): Int {
            return sharedPreferences.getInt(key, default)
        }

        override fun read(key: String, default: String): String {
            return sharedPreferences.getString(key,default) ?: default
        }
    }
}
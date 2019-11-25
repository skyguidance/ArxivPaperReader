package com.example.cardviewdemo.api.mysql

import com.example.androidtry.Rome2
import java.sql.*
import java.util.Properties

/**
 * Program to list databases in MySQL using Kotlin
 */
object mysql_search_history : mysql_basic() {
    internal var conn: Connection?=null

    fun mysql_search_history(UID: Int): MutableList<List<MutableList<String>>> {
        val articles=mutableListOf<List<MutableList<String>>>()
        getConnection()
        queryRows_userhistory(getConnection()!!, UID=UID).forEach {
            articles.add(Rome2().Rome2(it))
        }
        return articles
    }


}
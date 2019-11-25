package com.example.cardviewdemo.api.mysql

import com.example.androidtry.Rome2
import java.sql.*
import java.util.Properties

/**
 * This is the mysql_get_favorite Object.
 * This Object provides the operation to get articles of one user's history, supported by function provided by Rome2 .
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
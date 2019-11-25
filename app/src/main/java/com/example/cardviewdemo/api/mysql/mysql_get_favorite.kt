package com.example.cardviewdemo.api.mysql

import com.example.androidtry.Rome2
import java.sql.*

/**
 * This is the mysql_get_favorite Object.
 * This Object provides the operation to get articles of one user's favorite, supported by function provided by Rome2 .
 */
object mysql_get_favorite : mysql_basic() {

    internal var conn: Connection? = null

    fun mysql_get_favorite(UID: Int):MutableList<List<MutableList<String>>>{
        val articles = mutableListOf<List<MutableList<String>>>()
        queryRows_userfavoriterelations(getConnection()!!, UID = UID).forEach{
            articles.add(Rome2().Rome2(queryRows_favorite2(getConnection()!!, Fid = it)))
        }
        return articles
    }

}
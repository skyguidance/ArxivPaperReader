package com.example.cardviewdemo.api.mysql

import com.example.androidtry.Rome2
import java.sql.*

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
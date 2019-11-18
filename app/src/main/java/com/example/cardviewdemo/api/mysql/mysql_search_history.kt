package com.example.cardviewdemo.api.mysql

import com.example.androidtry.Rome2
import java.sql.*
import java.util.Properties

/**
 * Program to list databases in MySQL using Kotlin
 */
object mysql_search_history {
    internal var conn: Connection?=null

    fun getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            mysql_search_history.conn=DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "140.82.60.66" +
                        ":" + "3306" + "/"
                , "root", "4j{NjN(]dpwwuY9X"
            )
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }

    fun queryRows_userhistory(
        connection: Connection?=mysql_search_history.conn,
        schema: String="apr_users",
        table: String="history",
        UID: Int=1
    ): MutableList<String> {
        var arxivid: String
        var list_arxivid=mutableListOf<String>()
        val sql="SELECT arxivid FROM $schema.$table where UID = $UID"
        val rs=connection!!.createStatement().executeQuery(sql)
        while (rs.next()) {
            arxivid=rs.getString("arxivid")
            println(arxivid)
            //println("Fid: ${rs.getInt("Fid")}\t")
            list_arxivid.add(arxivid)
        }
        return list_arxivid
    }

    fun mysql_search_history(UID: Int=1): MutableList<List<MutableList<String>>> {
        val articles=mutableListOf<List<MutableList<String>>>()
        mysql_search_history.getConnection()
        mysql_search_history.queryRows_userhistory(UID=UID).forEach {
            articles.add(Rome2().Rome2(it))
        }
        return articles
    }


}
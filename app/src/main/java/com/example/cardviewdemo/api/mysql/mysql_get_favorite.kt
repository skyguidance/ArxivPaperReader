package com.example.cardviewdemo.api.mysql

import com.example.androidtry.Rome2
import java.sql.*

object mysql_get_favorite {

    internal var conn: Connection? = null
    fun getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection(
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

    fun queryRows_userfavoriterelations(
        connection: Connection? = conn,
        schema: String = "apr_users",
        table: String = "userfavoriterelations",
        UID: Int = 1
    ): MutableList<Int> {
        var Fid: Int = 0
        var list_Fid = mutableListOf<Int>()
        val sql = "SELECT Fid FROM $schema.$table where UID = $UID"
        val rs = connection!!.createStatement().executeQuery(sql)
        while (rs.next()) {
            Fid = rs.getInt("Fid")
            println(Fid)
            //println("Fid: ${rs.getInt("Fid")}\t")
            list_Fid.add(Fid)
        }
        return list_Fid
    }

    fun queryRows_favorite(
        connection: Connection? = conn,
        schema: String = "apr_users",
        table: String = "favorite",
        Fid: Int
    ): String {
        var arxivID: String = ""
        val sql = "SELECT Fid FROM $schema.$table where arxivID = $Fid"
        val rs = connection!!.createStatement().executeQuery(sql)
        while (rs.next()) {
            arxivID = rs.getString("arxivID")
        }
        return arxivID
    }

    fun mysql_get_favorite(UID: Int = 1):MutableList<List<MutableList<String>>>{
        val articles = mutableListOf<List<MutableList<String>>>()
        getConnection()
        queryRows_userfavoriterelations(UID = UID).forEach{
            articles.add(Rome2().Rome2(queryRows_favorite(Fid = it)))
        }
        return articles
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var UID: Int = 1
        val articles = mutableListOf<List<MutableList<String>>>()
        getConnection()
        queryRows_userfavoriterelations(UID = UID).forEach{
            articles.add(Rome2().Rome2(queryRows_favorite(Fid = it)))
        }
        println(articles)
        println(articles.size)
    }
}
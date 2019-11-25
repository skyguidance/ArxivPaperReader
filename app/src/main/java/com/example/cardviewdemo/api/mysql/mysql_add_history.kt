package com.example.cardviewdemo.api.mysql

import java.sql.*
import java.util.Properties

/**
 * Program to list databases in MySQL using Kotlin
 */
object mysql_add_history {

    internal var conn: Connection? = null
    internal var username = "root" // provide the username
    internal var password = "soE{Hq96" // provide the corresponding password


    fun insertRow_history(
        connection: Connection? = mysql_add_history.conn,
        schema: String,
        table: String,
        UID: String,
        arxivID: String
    ) {
        val sql = "INSERT INTO $schema.$table (uid,arxivid,date) VALUES ('$UID','$arxivID', NOW())"
        with(connection!!) {
            createStatement().execute(sql)
            commit()
        }
    }

    fun mysql_add_history(UID: Int, arxivID: String) {
        var Fid: Int
        println("DEBUG:mysql_add_history:" + UID + "......" + arxivID)
        mysql_add_history.getConnection()
        try {
            mysql_add_history.insertRow_history(
                mysql_add_history.conn,
                "apr_users",
                "history",
                UID.toString(),
                arxivID
            )
        } catch (sqlEx: SQLException) {
            print(sqlEx)
        }
    }

    fun getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            mysql_add_history.conn = DriverManager.getConnection(
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

}
package com.example.cardviewdemo.api.mysql

import java.sql.*
import java.util.Properties

/**
 * This is the mysql_add_history Object.
 * This Object provides the operation to add something into history table.
 */
object mysql_add_history : mysql_basic() {

    internal var conn: Connection? = null


    fun mysql_add_history(UID: Int, arxivID: String) {
        var Fid: Int
        println("DEBUG:mysql_add_history:" + UID + "......" + arxivID)
        mysql_add_history.getConnection()
        try {
            insertRow_history(
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


}
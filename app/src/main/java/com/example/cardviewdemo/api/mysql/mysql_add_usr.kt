package com.example.cardviewdemo.api.mysql

import java.sql.*
import java.util.Properties

/**
 * This is the mysql_add_usr Object.
 * This Object provides the operation to add usr into favorite table.
 */
object mysql_add_usr : mysql_basic() {
    fun mysql_add_usr( user : String, password : String): Int? {
        getConnection()
        return executeMySQLQuery(user, password)
    }

    internal var conn: Connection? = null
    fun executeMySQLQuery(usr: String, pwd : String): Int? {
        var stmt: Statement? = null
        var resultset: Int? = null
        try {
            stmt = conn!!.createStatement()
            var sql:String = "use apr_users;"
            var sql2:String = "INSERT INTO apr_users.user (username, password) VALUES ( '$usr', '$pwd');"
            resultset = stmt!!.executeUpdate(sql2)
            println(resultset)
            return resultset
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            if (resultset != null) {
                resultset = null
            }
            if (stmt != null) {
                try {
                    stmt.close()
                } catch (sqlEx: SQLException) {
                }
                stmt = null
            }
            if (conn != null) {
                try {
                    conn!!.close()
                } catch (sqlEx: SQLException) {
                }
                conn = null
            }
        }
        return 0
    }

}
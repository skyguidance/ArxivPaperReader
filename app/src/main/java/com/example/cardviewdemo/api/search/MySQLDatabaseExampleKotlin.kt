package com.example.cardviewdemo.api.search

import java.sql.*
import java.util.Properties
/**
 * Program to list databases in MySQL using Kotlin
 */
object MySQLDatabaseExampleKotlin {
    internal var conn: Connection? = null
//    internal var username = "username" // provide the username
//    internal var password = "password" // provide the corresponding password
    internal var username = "root" // provide the username
    //internal var password = "4j{NjN(]dpwwuY9X" // provide the corresponding password
    internal var password = "soE{Hq96" // provide the corresponding password
    @JvmStatic fun main(args: Array<String>) {
        // make a connection to MySQL Server
        getConnection()
        // execute the query via connection object
        executeMySQLQuery()
    }
    fun executeMySQLQuery() {
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt!!.executeQuery("SHOW DATABASES;")
            if (stmt.execute("SHOW DATABASES;")) {
                resultset = stmt.resultSet
            }
            while (resultset!!.next()) {
                println(resultset.getString("Database"))
            }
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            if (resultset != null) {
                try {
                    resultset.close()
                } catch (sqlEx: SQLException) {
                }
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
    }
    /**
     * This method makes a connection to MySQL Server
     * In this example, MySQL Server is running in the local host (so 127.0.0.1)
     * at the standard port 3306
     */
    fun getConnection() {
        val connectionProps = Properties()
        //connectionProps.put("user", username)
        //connectionProps.put("password", password)
        connectionProps.put("root", username)
        //connectionProps.put("4j{NjN(]dpwwuY9X", password)
        connectionProps.put("soE{Hq96", password)
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        //"127.0.0.1" +
                        "140.82.60.66" +
                        ":" + "3306" + "/" +
                        //"","root", "soE{Hq96")
                        "","root", "4j{NjN(]dpwwuY9X")
                //connectionProps)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }
}
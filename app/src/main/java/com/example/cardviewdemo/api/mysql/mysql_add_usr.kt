package com.example.cardviewdemo.api.mysql

import java.sql.*
import java.util.Properties
/**
 * Program to list databases in MySQL using Kotlin
 */
object mysql_add_usr {
    fun mysql_add_usr( user : String, password : String): Int? {
        getConnection()
        return executeMySQLQuery(user, password)
    }

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
        executeMySQLQuery("abc","kkkkk")
    }
    fun executeMySQLQuery(usr: String, pwd : String): Int? {
//        var usr : String = ""
//        var pwd : String = ""
//        usr = use
        var stmt: Statement? = null
        //var resultset: ResultSet? = null
        var resultset: Int? = null
        try {
            stmt = conn!!.createStatement()
            var sql:String = "use apr_users;"
            var sql2:String = "INSERT INTO apr_users.user (username, password) VALUES ( '$usr', '$pwd');"
//            resultset = stmt!!.executeQuery("use apr_users;"+
//                    //"INSERT INTO user (username, password) VALUES (\"$usr\",\"$pwd\");"
//                    "INSERT INTO user (username, password) VALUES ( '$usr', '$pwd');"
//            )
            //resultset = stmt!!.executeQuery(sql2)
            resultset = stmt!!.executeUpdate(sql2)
            println(resultset)
            return resultset
            //if (stmt.execute("SHOW DATABASES;")) {
//            if (stmt.execute(sql2)) {
//                //resultset = stmt.resultSet
//                resultset2 = stmt.updateCount
//                println(resultset2)
//            }
//            while (resultset2) {
//                //println(resultset.getString("Database"))
//                println(resultset2)
//            }
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            if (resultset != null) {
//                try {
//                    resultset.close()
//                } catch (sqlEx: SQLException) {
//                }
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
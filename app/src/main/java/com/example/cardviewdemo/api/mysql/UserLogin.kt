package com.example.cardviewdemo.api.mysql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/**
 * This is the UserLogin Object.
 * This Object is used to user login function.
 */
object UserLogin {

    internal var conn: Connection?=null


    fun checkRow_User(
        connection: Connection?=UserLogin.conn,
        schema: String,
        table: String,
        username: String,
        password: String
    ): Int {
        val sql=
            "SELECT username from $schema.$table where username = '$username'and password ='$password'"
        var rs=connection!!.createStatement().executeQuery(sql)
        var getusername=""
        if (rs.next()) {
            getusername=rs.getString("username")
        }
        if (getusername.equals(username)) {
            rs=connection!!.createStatement()
                .executeQuery("SELECT uid from $schema.$table where username = '$username'and password ='$password'")
            if (rs.next()) {
                return rs.getInt("UID")
            } else {
                return -1
            }
        } else {
            return -1
        }

    }

    fun doUserLogin(username: String, password: String): Int {
        println("DEBUG:doUserLogin:" + username + "......" + password)
        UserLogin.getConnection()
        try {
            return UserLogin.checkRow_User(
                UserLogin.conn,
                "apr_users",
                "user",
                username,
                password
            )
        } catch (sqlEx: SQLException) {
            print(sqlEx)
            return -1
        }
    }

    fun getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            UserLogin.conn=DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "140.82.60.66" +
                        ":" + "3306" + "/"
                , "user", "sLbc=TiNV6"
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
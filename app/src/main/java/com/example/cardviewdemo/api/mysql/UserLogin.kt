package com.example.cardviewdemo.api.mysql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


object UserLogin {

    internal var conn: Connection?=null


    fun checkRow_User(
        connection: Connection?=UserLogin.conn,
        schema: String,
        table: String,
        username: String,
        password: String
    ): Boolean {
        val sql=
            "SELECT username from $schema.$table where username = '$username'and password ='$password'"
        val rs=connection!!.createStatement().executeQuery(sql)
        var getusername=""
        if (rs.next()) {
            getusername=rs.getString("username")
        }
        return getusername.equals(username)
    }

    fun doUserRegister(username: String, password: String) {
        println("DEBUG:doUserLogin:" + username + "......" + password)
        UserLogin.getConnection()
        try {
            UserLogin.checkRow_User(
                UserLogin.conn,
                "apr_users",
                "user",
                username,
                password
            )
        } catch (sqlEx: SQLException) {
            print(sqlEx)
        }
    }

    fun getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            UserLogin.conn=DriverManager.getConnection(
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
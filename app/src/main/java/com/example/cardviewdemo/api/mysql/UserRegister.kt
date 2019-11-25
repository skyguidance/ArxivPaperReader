package com.example.cardviewdemo.api.mysql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/**
 * This is the UserLogin Object.
 * This Object is used to user register function.
 */
object UserRegister {

    internal var conn: Connection?=null


    fun insertRow_User(
        connection: Connection?=UserRegister.conn,
        schema: String,
        table: String,
        username: String,
        password: String
    ) {
        val sql="INSERT INTO $schema.$table (username,password) VALUES ('$username','$password')"
        with(connection!!) {
            createStatement().execute(sql)
            commit()
        }
    }

    fun doUserRegister(username: String, password: String) {
        println("DEBUG:doUserRegister:" + username + "......" + password)
        UserRegister.getConnection()
        try {
            UserRegister.insertRow_User(
                UserRegister.conn,
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
            UserRegister.conn=DriverManager.getConnection(
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
package com.example.cardviewdemo.api.mysql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


object getUserName {

    internal var conn: Connection?=null


    fun checkRow_User(
        connection: Connection?=getUserName.conn,
        schema: String,
        table: String,
        UID: String
    ): String {
        if (connection==null){
            getConnection()
        }
        val sql=
            "SELECT username from $schema.$table where uid = '$UID'"
        var rs=connection!!.createStatement().executeQuery(sql)
        var getusername=""
        if (rs.next()) {
            getusername=rs.getString("username")
            return getusername
        } else {
            println("Error!Trapped at checkRow_User!")
            return ""
        }

    }

    fun doGetUserName(thisUID: String): String {
        println("DEBUG:doGetUserName:" + thisUID)
        getUserName.getConnection()
        try {
            return getUserName.checkRow_User(
                getUserName.conn,
                "apr_users",
                "user",
                thisUID
            )
        } catch (sqlEx: SQLException) {
            print(sqlEx)
            return "ERROR!"
        }
    }

    fun getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            getUserName.conn=DriverManager.getConnection(
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
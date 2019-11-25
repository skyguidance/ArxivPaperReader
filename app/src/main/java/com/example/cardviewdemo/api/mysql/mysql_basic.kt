package com.example.cardviewdemo.api.mysql

import java.sql.Connection
import java.sql.SQLException
import java.sql.DriverManager

 abstract class mysql_basic{

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

    /**
     * This method makes a connection to MySQL Server
     * In this example, MySQL Server is running in the local host (so 127.0.0.1)
     * at the standard port 3306
     */
     fun getConnection(): Connection? {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            getUserName.conn=DriverManager.getConnection(
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
        return getUserName.conn
    }

     fun insertRow_favorite(connection: Connection?, schema : String, table : String, arxivID: String) {
        val sql = "INSERT INTO $schema.$table (arxivID, createTime) VALUES ('$arxivID', NOW())"
        with(connection!!) {
            createStatement().execute(sql)
            commit()
        }
    }

     fun insertRow_userfavoriterelations(connection: Connection?, schema : String = "apr_users", table : String = "userfavoriterelations", UID : Int = 1, Fid : Int) {
        val sql = "INSERT INTO $schema.$table (UID, Fid) VALUES ('$UID', '$Fid')"
        connection!!.autoCommit = false
        with(connection!!) {
            try{
                createStatement().execute(sql)
            }
            catch(sqlEx: SQLException){
                print("wrong")
            }
            commit()
        }
    }

     fun queryRows_favorite(connection: Connection?, schema : String = "apr_users", table : String, arxivID: String) : Int{
        var Fid : Int = 0
        val sql = "SELECT Fid FROM $schema.$table where arxivID = '$arxivID'"
        val rs = connection!!.createStatement().executeQuery(sql)
        if (rs.next()) {
            Fid = rs.getInt("Fid")
            //println(Fid)
            //println("Fid: ${rs.getInt("Fid")}\t")
        }
        return Fid
    }

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

    fun queryRows_userfavoriterelations(
        connection: Connection?,
        schema: String = "apr_users",
        table: String = "userfavoriterelations",
        UID: Int
    ): MutableList<Int> {
        var Fid: Int
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

    fun queryRows_favorite2(
        connection: Connection?,
        schema: String = "apr_users",
        table: String = "favorite",
        Fid: Int
    ): String {
        var arxivID: String = ""
        val sql = "SELECT arxivID FROM $schema.$table where Fid = $Fid"
        val rs = connection!!.createStatement().executeQuery(sql)
        while (rs.next()) {
            arxivID = rs.getString("arxivID")
        }
        return arxivID
    }

    fun queryRows_userhistory(
        connection: Connection?=mysql_search_history.conn,
        schema: String="apr_users",
        table: String="history",
        UID: Int=1
    ): MutableList<String> {
        var arxivid: String
        var list_arxivid=mutableListOf<String>()
        val sql="SELECT arxivid FROM $schema.$table where UID = $UID"
        val rs=connection!!.createStatement().executeQuery(sql)
        while (rs.next()) {
            arxivid=rs.getString("arxivid")
            println(arxivid)
            //println("Fid: ${rs.getInt("Fid")}\t")
            list_arxivid.add(arxivid)
        }
        return list_arxivid
    }



}
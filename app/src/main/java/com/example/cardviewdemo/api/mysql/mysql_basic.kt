/**
 * Create by Z. Li <zli51@gwu.edu>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. The George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.api.mysql

import java.sql.Connection
import java.sql.SQLException
import java.sql.DriverManager

/**
 * This is the MySQL Basic Class.
 * This class provides basic MySQL related operations.
 */
 abstract class mysql_basic{

    /**
     * This method makes a connection to MySQL Server
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

    /**
     * This method inserts one row to the favorite table.
     */
     fun insertRow_favorite(connection: Connection?, schema : String, table : String, arxivID: String) {
        val sql = "INSERT INTO $schema.$table (arxivID, createTime) VALUES ('$arxivID', NOW())"
        with(connection!!) {
            createStatement().execute(sql)
            commit()
        }
    }

    /**
     * This method inserts one row to the userfavoriterelation table.
     */
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

    /**
     * This method queries the favorite table.
     */
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

    /**
     * This method inserts one row to the hisotry table.
     */
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

    /**
     * This method queries the userfavoriterelations table.
     */
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

    /**
     * This method queries the favorite table. Different return value with queryRows_favorite.
     */
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

    /**
     * This method queries the user history table.
     */
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
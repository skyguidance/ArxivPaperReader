package com.example.cardviewdemo.api.mysql

import java.sql.*

object mysql_add_favorite{

    internal var conn: Connection? = null

    fun getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection(
                "jdbc:" + "mysql" + "://" +
                        "140.82.60.66" +
                        ":" + "3306" + "/"
                ,"root", "4j{NjN(]dpwwuY9X")
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }

    fun insertRow_favorite(connection: Connection? = conn, schema : String, table : String, arxivID: String) {
        val sql = "INSERT INTO $schema.$table (arxivID, createTime) VALUES ('$arxivID', NOW())"
        with(connection!!) {
            createStatement().execute(sql)
            commit()
        }
    }

    fun insertRow_userfavoriterelations(connection: Connection? = conn, schema : String = "apr_users", table : String = "userfavoriterelations", UID : Int = 1, Fid : Int) {
        val sql = "INSERT INTO $schema.$table (UID, Fid) VALUES ('$UID', '$Fid')"
        connection!!.autoCommit = false
        with(connection!!) {
            try{
                createStatement().execute(sql)
            }
            catch(sqlEx: SQLException){
            }
            commit()
        }
    }

    fun queryRows_favorite(connection: Connection? = conn, schema : String = "apr_users", table : String, arxivID: String) : Int{
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

    fun mysql_add_favorite(UID:Int, arxivID: String){
        var Fid : Int
        println("DEBUG:mysql_add_favorite:"+UID+"......"+arxivID)
        getConnection()
        try{
            insertRow_favorite(conn,"apr_users", "favorite", arxivID)
        }
        catch(sqlEx: SQLException){
        }
        Fid = queryRows_favorite(conn,"apr_users","favorite", arxivID)
        insertRow_userfavoriterelations(UID = 1, Fid = Fid)
    }

    @JvmStatic fun main(args: Array<String>) {
        // make a connection to MySQL Server
        var Fid : Int
        getConnection()
        conn!!.setAutoCommit(false)
        var arxivID : String = "http://arxiv.org/abs/1501.04914v1"
        // execute the query via connection object
        try{
            insertRow_favorite(conn,"apr_users", "favorite", arxivID)
        }
        catch(sqlEx: SQLException){
        }
        Fid = queryRows_favorite(conn,"apr_users","favorite", arxivID)
        println(Fid)
        insertRow_userfavoriterelations(UID = 1, Fid = Fid)
    }
}
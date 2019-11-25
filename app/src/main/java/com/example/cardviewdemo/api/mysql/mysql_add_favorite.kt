package com.example.cardviewdemo.api.mysql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/**
 * This is the mysql_add_favorite Object.
 * This Object provides the operation to add something into favorite table.
 */
 object mysql_add_favorite : mysql_basic(){

    internal var conn: Connection? = null

     fun mysql_add_favorite(UID:Int, arxivID: String){
        var Fid : Int
        println("DEBUG:mysql_add_favorite:"+UID+"......"+arxivID)
        getConnection()
        try{
            insertRow_favorite(conn,"apr_users", "favorite", arxivID)
        }
        catch(sqlEx: SQLException){
            print("wrong")
        }
        Fid = queryRows_favorite(conn,"apr_users","favorite", arxivID)
        insertRow_userfavoriterelations(getConnection()!!, UID = 1, Fid = Fid)
    }

 }
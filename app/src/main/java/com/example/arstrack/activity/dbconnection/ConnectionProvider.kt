package com.example.arstrack.activity.dbconnection

import android.util.Log
import java.sql.Connection
import java.sql.DriverManager

object ConnectionProvider {
    private var con: Connection? = null

    val connection: Connection?
        get() {
            try {
                if (con == null) {
                    Class.forName("com.mysql.jdbc.Driver")
                    val url =
                        "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12604762"
                    val username = "sql12604762"
                    val password = "El2ectGjkh"
//                    val url =
//                        "jdbc:mysql://192.168.1.12:3306/ars?allowPublicKeyRetrieval=true&useSSL=false"
//                    val username = "root"
//                    val password = "Abhi@1234"
                    con = DriverManager.getConnection(url, username, password)
                    Log.d("ConnectionProvider", "Connection established")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("ConnectionProvider", e.message!!)
            }
            return con
        }
}
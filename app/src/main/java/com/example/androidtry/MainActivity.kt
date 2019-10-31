package com.example.androidtry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.net.URL
import java.net.HttpURLConnection
import java.io.File
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import android.content.Intent




class MainActivity : AppCompatActivity() {

    //var c : MutableList<List<MutableList<String>>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        io()
        //val d = c?.run { get(0) .get(0).get(0)}
        //val duration = Toast.LENGTH_SHORT;
        //val toast = Toast.makeText(applicationContext, d, duration)
        //toast.show()

        //println(Rome().size)
        //println("HelloWorld!")
    }

    fun io() {

        Thread(
            {
                val rome =  Rome()
                val b = rome.Rome()
                val duration = Toast.LENGTH_SHORT;
                val toast = Toast.makeText(applicationContext, b[0][0].toString(),duration)
                toast.show()

            }
        ).start()

    }

}

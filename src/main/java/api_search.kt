package com.javasampleapproach.kotlin.jsonxml
import java.net.URL
import java.net.HttpURLConnection
import java.io.File
import org.json.XML

fun main() {
    val str = "http://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10"
    println("Hello World!")
    //URL("https://google.com").readText()
    sendGet1(str)
    val PRETTY_PRINT_INDENT_FACTOR = 4
    var xmlString: String
    var xmlFile = System.getProperty("user.dir") + "/aa.xml"

    xmlString = File(xmlFile).readText()
    var xmlJSONObj = XML.toJSONObject(xmlString)

    val jsonFile = System.getProperty("user.dir") + "/aa.json"
    File(jsonFile).writeText(xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR))
    var mutableList: MutableList<File> = mutableListOf()
    mutableList.add(File(jsonFile))
    println(mutableList+"abcd!!!")
}

fun sendGet1(url:String) {
    //val url = URL("http://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10")
    val url = URL(url)

    with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"  // optional default is GET

        println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

        inputStream.bufferedReader().use {
            File("./aa.xml").writeText(it.readText())
        }
    }
}
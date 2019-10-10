package com.javasampleapproach.kotlin.jsonxml

import java.io.File
import org.json.JSONObject
import org.json.XML

fun main(args: Array<String>) {
    // 1. Convert XML String -> Json String
    val PRETTY_PRINT_INDENT_FACTOR = 4

    var xmlString = "<Customer>" +
            "  <name>Mary</name>" +
            "  <age>37</age>" +
            "  <address>" +
            "    <street>NANTERRE CT</street>" +
            "    <postcode>77471</postcode>" +
            "  </address>" +
            "</Customer>"

    var xmlJSONObj = XML.toJSONObject(xmlString)
    val jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR)

    println(jsonPrettyPrintString)
    /*
      {"Customer": {
          "address": {
              "street": "NANTERRE CT",
              "postcode": 77471
          },
          "name": "Mary",
          "age": 37
      }}
     */

    // 2. Convert XML File -> Json File
//    var xmlString: String
//    var xmlFile = System.getProperty("user.dir") + "/a.xml"
//
//    xmlString = File(xmlFile).readText()
//    var xmlJSONObj = XML.toJSONObject(xmlString)
//
//    val jsonFile = System.getProperty("user.dir") + "/a.json"
//    File(jsonFile).writeText(xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR))
//    var mutableList: MutableList<File> = mutableListOf()
//    mutableList.add(File(jsonFile))
//    println(mutableList+"abcd!!!")

}
package com.example.cardviewdemo.model

/*
*
Weblink: result.get(0).get(0).get(0)
Title: result.get(0).get(1).get(0)
AuthorCount:result.get(0).get(2).size
Author:result.get(0).get(2).get(N)
Abstract:result.get(0).get(3).get(0)
Catorgary:result.get(0).get(4).get(0)
UpdateTime:result.get(0).get(5).get(0)
PDFlink: result.get(0).get(8).get(0)
ArxivID: result.get(0).get(9).get(0)
*/

data class PaperBean(
    var Weblink: String,
    var Title: String,
    var Author: String,
    var Abstract: String,
    var Catorgary: String,
    var UpdateTime: String,
    var PDFLink: String,
    var ArxivID: String
)

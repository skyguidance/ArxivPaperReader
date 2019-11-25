/**
 * Create by Li, Ziyue <zli19@outlook.com>
 * CSCI 6221 Course Project - Team 15 - Fall 2019. The George Washington University.
 * Copyright 2019 - Present
 */
package com.example.cardviewdemo.api.search
import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import java.net.URL

/**
 * This is the Rome Class
 * This class use the API provided by arXiv and process the result returned from arXiv API.
 */
open class Rome {

    fun Rome(start : Int, keywords : String, cat : String): MutableList<List<MutableList<String>>> {
        println("Rome DEBUG:"+start.toString()+"Rome DEBUG:"+keywords+"Rome DEBUG:"+cat)
        val start_num = start.toString()
        var url_new : String = ""
        if(keywords == "" && cat == "")
        {
            val url = "http://export.arxiv.org/api/query?search_query=all&start=0&max_results=10&sortBy=lastUpdatedDate&sortOrder=descending"
            url_new = url.replace(Regex("start=0"), "start=$start_num")
        }
        else if(keywords == "")
        {
            val url = "http://export.arxiv.org/api/query?search_query=cat:cond-mat.str-el&start=0&max_results=10&sortBy=lastUpdatedDate&sortOrder=descending"
            val url2 = url.replace(Regex("cat:cond-mat.str-el"), "cat:$cat")
            url_new = url2.replace(Regex("start=0"), "start=$start_num")
        }
        else if(cat == "")
        {
            val url = "http://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10&sortBy=lastUpdatedDate&sortOrder=descending"
            val url2 = url.replace(Regex("all:electron"), "all:$keywords")
            url_new = url2.replace(Regex("start=0"), "start=$start_num")
        }
        else
        {
            val url = "http://export.arxiv.org/api/query?search_query=all:electron+AND+cat:cond-mat.str-el&start=0&max_results=10&sortBy=lastUpdatedDate&sortOrder=descending"
            val url2 = url.replace(Regex("all:electron"), "all:$keywords")
            val url3 = url2.replace(Regex("start=0"), "start=$start_num")
            url_new = url3.replace(Regex("cat:cond-mat.str-el"), "cat:$cat")
        }
        lateinit var feed: SyndFeed
        try {
            feed = SyndFeedInput().build(XmlReader(URL(url_new)))
        }catch (e:Exception){
            return mutableListOf<List<MutableList<String>>>()
        }
        val articles = mutableListOf<List<MutableList<String>>>()
        for(j in 0..9) {
            var a = feed.entries.elementAt(j)
            val map_authors = hashMapOf<Int, String>()
            val list_authors = mutableListOf<String>()
            var i: Int = 1
            for (authors in a.authors) {
                println("authors:" + authors.name)
                map_authors.put(i, authors.name)
                i++
                list_authors.add(authors.name)
            }
            val map_categories = hashMapOf<Int, String>()
            val list_categories = mutableListOf<String>()
            i = 1
            var cat_str:String = ""
            for (categories in a.categories) {
                println("categories:" + categories.name)
                map_categories.put(i, categories.name)
                cat_str = cat_str + categories.name + " "
            }
            list_categories.add(cat_str)
            var uri = a.uri
            val list_uri = mutableListOf<String>(a.uri)
            var pdf = uri.replace(Regex("/abs/"), "/pdf/")+".pdf"
            val list_pdf = mutableListOf<String>(pdf)
            //var title = a.title
            val list_title = mutableListOf<String>(a.title)
            //var description = a.description.value
            val list_description = mutableListOf<String>(a.description.value)
            //var publishedDate = a.publishedDate.toString()
            val list_publishedDate = mutableListOf<String>(a.publishedDate.toString())
            //var updatedDate = a.updatedDate.toString()
            val list_updatedDate = mutableListOf<String>(a.updatedDate.toString())
            val map_links = hashMapOf<Int, String>()
            val list_links = mutableListOf<String>()
            i = 1
            for (links in a.links) {
                map_links.put(i, links.href)
                i++
                list_links.add(links.href)
            }
            val entry = listOf(list_uri, list_title, list_authors, list_description, list_categories, list_publishedDate, list_updatedDate, list_links, list_pdf)
            articles.add(entry)
        }
        //val b = articles.get(2).get(2)
        return articles
    }
}
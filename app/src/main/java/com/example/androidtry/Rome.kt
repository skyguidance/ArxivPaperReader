package com.example.androidtry
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import java.net.URL

class Rome {

    fun Rome(): MutableList<List<MutableList<String>>> {
        //val url = "https://stackoverflow.com/feeds/tag?tagnames=rome"
        val url = "http://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10"
        //val url = "file://Users/ziyueli/IdeaProjects/ROME/a.xml"
        val feed = SyndFeedInput().build(XmlReader(URL(url)))
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
            for (categories in a.categories) {
                println("categories:" + categories.name)
                map_categories.put(i, categories.name)
                list_categories.add(categories.name)
            }
            var uri = a.uri
            val list_uri = mutableListOf<String>(a.uri)
            //println("uri:" + uri)
            var title = a.title
            val list_title = mutableListOf<String>(a.title)
            //println("title:" + title)
            var description = a.description.value
            val list_description = mutableListOf<String>(a.description.value)
            //println("description:" + description)
            var publishedDate = a.publishedDate.toString()
            val list_publishedDate = mutableListOf<String>(a.publishedDate.toString())
            //println("publishedDate:" + publishedDate)
            var updatedDate = a.updatedDate.toString()
            val list_updatedDate = mutableListOf<String>(a.updatedDate.toString())
            //println("updatedDate:" + updatedDate)
            val map_links = hashMapOf<Int, String>()
            val list_links = mutableListOf<String>()
            i = 1
            for (links in a.links) {
                //println("links:" + links.href)
                map_links.put(i, links.href)
                i++
                list_links.add(links.href)
            }
            //val map = mapOf<String, kotlin.collections.HashMap<Int, String>>()
            //val entry = listOf(map_authors, map_categories, uri, title, description, publishedDate, updatedDate, map_links)
            //val entry = listOf(uri, title, list_authors, description, list_categories, publishedDate, updatedDate, list_links)
            val entry = listOf(list_uri, list_title, list_authors, list_description, list_categories, list_publishedDate, list_updatedDate, list_links)
            //println("list:" + entry)
            //println(entry.size)
            articles.add(entry)
        }
        //println(articles)
        //println(articles.size)
        val b = articles.get(2).get(2)

        //println(articles.get(2).get(2))
        return articles
    }
}
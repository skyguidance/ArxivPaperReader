package com.example.androidtry
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import java.net.URL

class Rome2 {

    fun Rome2(arxivid : String): List<MutableList<String>> {
        val url = arxivid
        val url2 = url.replace(Regex("http://arxiv.org/abs/"), "http://export.arxiv.org/api/query?id_list=")
        val feed = SyndFeedInput().build(XmlReader(URL(url2)))
        var a = feed.entries.elementAt(0)
        val map_authors = hashMapOf<Int, String>()
        val list_authors = mutableListOf<String>()
        var i: Int = 1
        for (authors in a.authors) {
            map_authors.put(i, authors.name)
            i++
            list_authors.add(authors.name)
        }
        val map_categories = hashMapOf<Int, String>()
        val list_categories = mutableListOf<String>()
        i = 1
        for (categories in a.categories) {
            map_categories.put(i, categories.name)
            list_categories.add(categories.name)
        }
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
        return entry
    }
}
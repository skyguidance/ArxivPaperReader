import java.net.URL
import java.net.HttpURLConnection
import java.io.File
import org.json.XML
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.XmlReader
import java.io.Serializable
import kotlin.collections.HashMap as HashMap1

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

fun main(){
    //val url = "https://stackoverflow.com/feeds/tag?tagnames=rome"
    val url = "http://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10"
    //val url = "file://Users/ziyueli/IdeaProjects/ROME/a.xml"
    val feed = SyndFeedInput().build(XmlReader(URL(url)))
    val articles = mutableListOf<List<Any?>>()
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
        println("uri:" + uri)
        var title = a.title
        println("title:" + title)
        var description = a.description.value
        println("description:" + description)
        var publishedDate = a.publishedDate.toString()
        println("publishedDate:" + publishedDate)
        var updatedDate = a.updatedDate.toString()
        println("updatedDate:" + updatedDate)
        val map_links = hashMapOf<Int, String>()
        val list_links = mutableListOf<String>()
        i = 1
        for (links in a.links) {
            println("links:" + links.href)
            map_links.put(i, links.href)
            i++
            list_links.add(links.href)
        }
        //val map = mapOf<String, kotlin.collections.HashMap<Int, String>>()
        //val entry = listOf(map_authors, map_categories, uri, title, description, publishedDate, updatedDate, map_links)
        val entry = listOf(uri, title, list_authors, description, list_categories, publishedDate, updatedDate, list_links)
        println("list:" + entry)
        //println(entry.size)
        articles.add(entry)
    }
    //println(articles)
    println(articles.size)
    val b = articles.get(2).get(2)

    println(articles.get(2).get(2))

    //val mMap = hashMapOf("a" to a.author, "b" to 2, "c" to 3)

    //println(feed.entries.get(2))
//    val str = "http://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10"
//    println("Hello World!")
//    //URL("https://google.com").readText()
//    sendGet1(str)
//    val PRETTY_PRINT_INDENT_FACTOR = 4
//    var xmlString: String
//    var xmlFile = System.getProperty("user.dir") + "/aa.xml"
//
//    xmlString = File(xmlFile).readText()
//    var xmlJSONObj = XML.toJSONObject(xmlString)
//
//    val jsonFile = System.getProperty("user.dir") + "/aa.json"
//    File(jsonFile).writeText(xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR))
//    var mutableList: MutableList<File> = mutableListOf()
//    mutableList.add(File(jsonFile))
//    println(mutableList+"abcd!!!")
}


import java.net.URL
import java.net.HttpURLConnection
import java.io.File




fun main() {
    val str = "http://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10"
    println("Hello World!")
    //URL("https://google.com").readText()
    sendGet(str)
}

fun sendGet(url:String) {
    //val url = URL("http://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10")
    val url = URL(url)

    with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"  // optional default is GET

        println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

        inputStream.bufferedReader().use {
            File("./a.xml").writeText(it.readText())
        }
    }
}
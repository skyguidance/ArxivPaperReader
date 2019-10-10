import org.json.XML
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

fun main() {
    val str = "http://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10"
    println("Hello World!")
    val PRETTY_PRINT_INDENT_FACTOR = 4
    //URL("https://google.com").readText()
    var xmlString = sendGet2(str)
    var xmlJSONObj = XML.toJSONObject(xmlString)
    val jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR)
    var mutableList: MutableList<String> = mutableListOf()
    mutableList.add(jsonPrettyPrintString)
    println(mutableList+"abcd!!!")

   // println(jsonPrettyPrintString)

}

fun sendGet2(url:String):String {
    //val url = URL("http://export.arxiv.org/api/query?search_query=all:electron&start=0&max_results=10")
    val url = URL(url)

    with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"  // optional default is GET

        println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

        inputStream.bufferedReader().use {
            return it.readText()
            //File("./aa.xml").writeText(it.readText())
        }
    }
}
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File
import java.io.InputStream

internal val kotlinXmlMapper = XmlMapper(JacksonXmlModule().apply {
    setDefaultUseWrapper(false)
}).registerKotlinModule()
    .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)


internal inline fun <reified T : Any> parseAs(path: String): T {
    val resource = /*acquire a classLoader*/InputStream::class.java.getResource(path)
    return kotlinXmlMapper.readValue(resource)

}

fun main(args: Array<String>) {
    val ledgersInCode = parseAs<LedgerActivities>("/Users/ziyueli/IdeaProjects/HelloWorld_Kotlin/a.xml")
    println(ledgersInCode.ledgerActivities[0]) // the first action!!!
}
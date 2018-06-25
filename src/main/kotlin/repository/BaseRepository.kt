package repository

import entity.FullParameters
import entity.HttpResponse
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

abstract class BaseRepository {


    fun execute(fullParam: FullParameters): HttpResponse {
        val conn: HttpURLConnection
        val response: HttpResponse


        val url = URL(fullParam.url + getQuery(fullParam.parameters))
        conn = url.openConnection() as HttpURLConnection
        conn.readTimeout = 100000
        conn.connectTimeout = 120000
        conn.requestMethod = fullParam.method.toString()
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
        conn.setRequestProperty("charset", "utf-8")
        conn.useCaches = false


        conn.connect()
        val code = conn.responseCode
        if (code == 404 || code == 500) {
            response = HttpResponse(code, "")
        } else {
            val input = conn.inputStream
            response = HttpResponse(code, getStringForStream(input))
        }
        return response
    }

    fun getStringForStream(input: InputStream): String {
        try {
            val attrBuilder = StringBuilder()
            val br = BufferedReader(InputStreamReader(input))

            for (line in br.readLines())
                attrBuilder.append(line)

            return attrBuilder.toString()

        } catch (e: Exception) {
            return ""
        }

    }

    fun getQuery(params: Map<String, String>): String {
        if (params.isEmpty()) return ""

        val ret = StringBuilder()
        var first = true

        for (p in params) {
            if (first) {
                ret.append("?")
                first = false
            } else {
                ret.append("&")
            }

            ret.append(URLEncoder.encode(p.key, "utf-8"))
                    .append("=")
                    .append(URLEncoder.encode(p.value, "utf-8"))

        }

        return ret.toString()
    }
}
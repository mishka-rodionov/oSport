package com.rodionov.osport.data.network.interceptors

import android.util.Log
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.rodionov.osport.data.dto.response.CompetitionShortResponse
import okhttp3.*
import okhttp3.ResponseBody.Companion.toResponseBody

class MockInterceptor(
    private val gson: Gson
) : Interceptor {

    val list = buildCompetitionShorts()

    override fun intercept(chain: Interceptor.Chain): Response {
        Log.d("LOG_TAG", "MockInterceptor: url ${chain.request().url}")
        when (chain.request().url.toString()) {
            "http://192.168.1.49:8080/competition/get_list" -> {
                val response = chain.proceed(chain.request())
                return createNeededResponse(response, getCompetitionShorts(0, 10))
            }
        }
        return chain.proceed(chain.request())
    }

    private fun createNeededResponse(response: Response, source: Any?): Response {
        return response.newBuilder().body(
            gson.toJson(
                source
            )
                .toResponseBody(response.body?.contentType())
        )
            .code(200)
            .build()
    }

    private fun getCompetitionShorts(offset: Long, limit: Int): List<CompetitionShortResponse> {
        return list.subList(offset.toInt(), limit)
    }

    private fun buildCompetitionShorts(): List<CompetitionShortResponse> {
        val list  = mutableListOf<CompetitionShortResponse>()
        for (index in 0 until 100) {
            list.add(
                CompetitionShortResponse(
                    id = "${index}qwe",
                    image = null,
                    title = "Test competition number $index",
                    date = "$index.12.2021",
                    time = "$index:00",
                    details = "Details $index"
                )
            )
        }
        return listOf(

        )
    }

}

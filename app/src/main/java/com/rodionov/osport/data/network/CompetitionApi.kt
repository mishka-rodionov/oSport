package com.rodionov.osport.data.network

import com.rodionov.osport.data.dto.requests.CompetitionRequest
import com.rodionov.osport.data.dto.response.CompetitionShortResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface CompetitionApi {

    @POST(GET_COMPETITIONS)
    suspend fun getCompetitionsShort(@Body competitionRequest: CompetitionRequest): List<CompetitionShortResponse>

    companion object {
        const val COMPETITION_NEW = "/competition/new"
        const val PARTICIPANT_NEW = "/competition/participant/new"
        const val GENERATE_START_LISTS = "/competition/generate/start_list"
        const val GET_PARTICIPANTS = "/competition/participants"
        const val GET_START_LIST = "/competition/start_list"
        const val GET_COMPETITIONS = "/competition/get_list"
    }

}
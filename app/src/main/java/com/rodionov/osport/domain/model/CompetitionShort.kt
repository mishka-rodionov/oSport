package com.rodionov.osport.domain.model

data class CompetitionShort(
    val id: String,
    val image: String?,
    val title: String,
    val date: String,
    val time: String,
    val details: String
)

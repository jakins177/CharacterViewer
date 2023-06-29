package com.sample.simpsonsviewer.repo.remote

import com.sample.simpsonsviewer.SimpsonModel.SimpsonsData
import retrofit2.Response
import retrofit2.http.GET

import retrofit2.http.Query
import retrofit2.http.Url

interface CharacterService {
    @GET
    suspend fun getCharactersByShow(
        @Url url: String,
        @Query("q", encoded = true) requestQuery: String,
        @Query("format") requestFormat: String
    ): Response<SimpsonsData>
}
package com.sample.simpsonsviewer.repo.remote

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

   // private const val BASE_URL = "https://api.openweathermap.org"

    private const val BASE_URL = "https://api.duckduckgo.com"
    private val moshi = Moshi.Builder()
   //     .add(KotlinJsonAdapterFactory())
        .build()

//    private val retrofit = Retrofit.Builder()
//        .baseUrl("")
//        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .build()

    val weatherService: WeatherService by lazy { retrofit.create(WeatherService::class.java) }
    val characterService: CharacterService by lazy { retrofit.create(CharacterService::class.java)}



}
package com.example.weatherexercise.repo.remote

import android.util.Log
import com.example.weatherexercise.SimpsonModel.SimpsonsData
import com.example.weatherexercise.util.ApiState
import kotlinx.coroutines.flow.flow
import org.w3c.dom.CharacterData


object CharacterRepo {
    private const val tailURL = "+characters&format=json"
    private val characterService by lazy { RetrofitInstance.characterService }
    private  val TAG = "CharacterRepo"
    fun getCharactersState (
        show: String
    ) = flow<ApiState<SimpsonsData>>{
        emit(ApiState.Loading)
        
        val state =
            if(true) {
                val characterResponse = characterService.getCharactersByShow("","simpsons+characters","json")
                if(characterResponse.isSuccessful) {
                    Log.i(TAG, "getCharactersState: response body is : ${characterResponse.body()}")
                    ApiState.Success(characterResponse.body()!!)
                    
                } else {
                    ApiState.Failure("Error fetching data.")
                }
            } else {
                ApiState.Error("Unknown error fetching API")
            }
        emit(state)
        
    }
}
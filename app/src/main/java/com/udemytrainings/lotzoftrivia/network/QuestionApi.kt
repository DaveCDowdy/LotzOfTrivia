package com.udemytrainings.lotzoftrivia.network

import com.udemytrainings.lotzoftrivia.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question
}
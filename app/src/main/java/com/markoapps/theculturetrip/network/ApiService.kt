package com.markoapps.theculturetrip.network

import com.markoapps.theculturetrip.models.ArticleResponse
import retrofit2.http.GET

interface ApiService {

    @GET("response.json")
    suspend fun getArticles(): ArticleResponse
}
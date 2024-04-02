package com.testmvvmapp.features.bybit.data.remote

import com.testmvvmapp.features.bybit.data.remote.dto.ByBitDTO
import retrofit2.http.GET

interface IBybitService {
    @GET("/v5/announcements/index?locale=en-US&limit=10")
    suspend fun get(): ByBitDTO?
    companion object {
        const val BASE_URL = "https://api.bybit.com"
    }
}
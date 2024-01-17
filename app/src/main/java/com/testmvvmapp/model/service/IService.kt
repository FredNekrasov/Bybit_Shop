package com.testmvvmapp.model.service

import com.testmvvmapp.model.service.dto.ByBitDTO
import retrofit2.Call
import retrofit2.http.GET

interface IService {
    @GET("/v5/announcements/index?locale=en-US&limit=10")
    fun get(): Call<List<ByBitDTO>>
    companion object {
        const val BASE_URL = "https://api.bybit.com"
    }
}
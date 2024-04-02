package com.testmvvmapp.features.bybit.di

import com.testmvvmapp.features.bybit.data.remote.IBybitService
import com.testmvvmapp.features.bybit.data.repositories.BybitRepository
import com.testmvvmapp.features.bybit.data.repositories.IBybitRepository
import com.testmvvmapp.features.bybit.presentation.viewModel.BybitVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val bybitModule = module {
    single(createdAtStart = true) {
        Retrofit.Builder()
            .baseUrl(IBybitService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(IBybitService::class.java)
    }
    //repositories
    single<IBybitRepository> { BybitRepository(get<IBybitService>()) }
    //viewModels
    viewModel { BybitVM(get<IBybitRepository>()) }
}
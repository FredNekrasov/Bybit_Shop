package com.testmvvmapp.di

import androidx.room.Room
import com.testmvvmapp.model.local.MainDB
import com.testmvvmapp.model.repository.*
import com.testmvvmapp.model.service.IBybitService
import com.testmvvmapp.view_model.BybitVM
import com.testmvvmapp.view_model.UserVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single(createdAtStart = true) {
        Room.databaseBuilder(get(), MainDB::class.java, MainDB.DB_NAME)
            .allowMainThreadQueries()
            .build()
    }
    single(createdAtStart = true) {
        Retrofit.Builder()
            .baseUrl(IBybitService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(IBybitService::class.java)
    }
    //repositories
    single<IBybitRepository> { BybitRepository(get<IBybitService>()) }
    single<UserRepository> { UserRepositoryImpl(get<MainDB>().userDao) }
    //viewModels
    viewModel { BybitVM(get<IBybitRepository>()) }
    viewModel { UserVM(get<UserRepository>()) }
}
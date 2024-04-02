package com.testmvvmapp.features.user.di

import androidx.room.Room
import com.testmvvmapp.features.user.data.local.MainDB
import com.testmvvmapp.features.user.data.repositories.UserRepository
import com.testmvvmapp.features.user.data.repositories.UserRepositoryImpl
import com.testmvvmapp.features.user.presentation.viewModel.UserVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userModule = module {
    single(createdAtStart = true) {
        Room.databaseBuilder(get(), MainDB::class.java, MainDB.DB_NAME)
            .allowMainThreadQueries()
            .build()
    }
    //repositories
    single<UserRepository> { UserRepositoryImpl(get<MainDB>().userDao) }
    //viewModels
    viewModel { UserVM(get<UserRepository>()) }
}
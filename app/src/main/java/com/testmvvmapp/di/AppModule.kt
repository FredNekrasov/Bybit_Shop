package com.testmvvmapp.di

import android.app.Application
import androidx.room.Room
import com.testmvvmapp.model.local.MainDB
import com.testmvvmapp.model.repository.*
import com.testmvvmapp.model.service.IService
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDB(app: Application) = Room.databaseBuilder(app,MainDB::class.java,MainDB.DB_NAME)
        .allowMainThreadQueries().build()
    @Provides
    @Singleton
    fun provideService(): IService = Retrofit.Builder().baseUrl(IService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(IService::class.java)
    @Provides
    @Singleton
    fun provideRepository(service: IService): IRepository = Repository(service)
    @Provides
    @Singleton
    fun provideUserRepository(mainDB: MainDB): UserRepository = UserRepositoryImpl(mainDB.userDao)
}
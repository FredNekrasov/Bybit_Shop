package com.testmvvmapp.di

import com.testmvvmapp.model.repository.IRepository
import com.testmvvmapp.model.repository.Repository
import com.testmvvmapp.model.service.IService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideService(): IService = Retrofit.Builder().baseUrl(IService.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build().create(IService::class.java)
    @Provides
    @Singleton
    fun provideRepository(service: IService): IRepository = Repository(service)
}
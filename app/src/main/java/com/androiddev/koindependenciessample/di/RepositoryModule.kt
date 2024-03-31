package com.androiddev.koindependenciessample.di

import com.androiddev.koindependenciessample.data.repository.AlbumRepositoryImpl
import com.androiddev.koindependenciessample.domain.repository.AlbumRepository
import com.androiddev.koindependenciessample.data.utils.Connectivity
import com.androiddev.koindependenciessample.data.utils.ConnectivityImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<Connectivity> { ConnectivityImpl(androidContext()) }
    factory<AlbumRepository> { AlbumRepositoryImpl(get(), get(), get()) }
}
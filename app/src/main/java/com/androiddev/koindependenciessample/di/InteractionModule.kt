package com.androiddev.koindependenciessample.di

import com.androiddev.koindependenciessample.domain.usecases.GetAlbumUseCase
import com.androiddev.koindependenciessample.domain.usecases.GetAlbumUseCaseImpl
import org.koin.dsl.module

val interactionModule = module {
  factory<GetAlbumUseCase> { GetAlbumUseCaseImpl(get()) }
}
package com.androiddev.koindependenciessample.di

import com.androiddev.koindependenciessample.ui.presentation.vm.AlbumViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { AlbumViewModel(get()) }
}
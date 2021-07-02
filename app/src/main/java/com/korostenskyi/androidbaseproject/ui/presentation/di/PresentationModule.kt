package com.korostenskyi.androidbaseproject.ui.presentation.di

import com.korostenskyi.androidbaseproject.ui.presentation.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { HomeViewModel() }
}

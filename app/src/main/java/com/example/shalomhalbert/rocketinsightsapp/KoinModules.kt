package com.example.shalomhalbert.rocketinsightsapp

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modelModules = module {
    single { RetrofitGenerator.service }
    single { Repository(get()) }
}

val viewModelModules = module {
    viewModel { MainViewModel(get()) }
}
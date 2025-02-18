package com.smartlink.smartlinkapp


import org.koin.dsl.module

val appModule = module {
    //single { MyRepository() }  // Singleton
    //viewModel { MyViewModel(get()) }  // ViewModel Injection
}
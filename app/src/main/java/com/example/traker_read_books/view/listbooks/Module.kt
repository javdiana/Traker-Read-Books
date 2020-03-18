package com.example.traker_read_books.view.listbooks

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        listOf(
            viewModelModule,
            repositoryModule,
            networkModule
        )
    )
}

val viewModelModule: Module = module {
    viewModel { ListBookViewModel()}
}

val repositoryModule: Module = module {
    //single<AuthorityRepository> { AuthorityRepositoryImpl(get()) }
}

val networkModule: Module = module {
    //single { apiService }
}
package com.everis.androidintermedio2

import android.app.Application
import com.example.data2.GetElementRepository
import com.example.domain2.*
import com.example.presentation.view.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // modules
            modules(myModule)
        }
    }

    // just declare it
    val myModule = module {
        single<IGetElementRepository> { GetElementRepository() }
        factory { GetElements(get()) }
        factory { GetElement(get()) }
        factory { AddElement(get()) }
        factory { DeleteElement(get()) }
        viewModel { MainViewModel(get(), get()) }
        viewModel { LoginViewModel() }
        viewModel { ProductListViewModel() }
        viewModel { ProductDetailViewModel() }
        viewModel { ImagesPagerViewModel() }
    }
}
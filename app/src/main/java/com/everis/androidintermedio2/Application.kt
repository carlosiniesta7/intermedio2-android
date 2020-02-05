package com.everis.androidintermedio2

import android.app.Application
import com.example.data2.GetElementRepository
import com.example.domain2.*
import com.example.presentation.view.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import com.example.presentation.view.LoginViewModel as LoginViewModel

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
        factory { DoLogin(get()) }
        factory { GetImages(get()) }
        viewModel<MainViewModel> { MainViewModel(get(), get()) }
        viewModel<LoginViewModel> { LoginViewModel(get()) }
        viewModel<ProductListViewModel> { ProductListViewModel(get()) }
        viewModel<ProductDetailViewModel> { ProductDetailViewModel() }
        viewModel<ImagesPagerViewModel> { ImagesPagerViewModel(get()) }
    }
}
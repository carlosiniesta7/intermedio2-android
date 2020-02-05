package com.everis.androidintermedio2

import android.app.Application
import com.example.data2.GetElementRepository
import com.example.domain2.AddElement
import com.example.domain2.GetElement
import com.example.domain2.IGetElementRepository
import com.example.presentation.view.MainViewModel
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
        factory { GetElement(get()) }
        factory { AddElement(get()) }
        viewModel { MainViewModel(get(), get()) }
    }
}
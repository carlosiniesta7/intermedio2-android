package es.example.presentation

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel <STATE : Parcelable, TRANSITION>() : ViewModel() {

    protected val viewState = MutableLiveData<STATE>()
    protected val viewTransition = SingleLiveEvent<TRANSITION>()

    fun getViewState() = viewState as LiveData<STATE>
    fun getViewTransition() = viewTransition as LiveData<TRANSITION>


    fun loadState(state: STATE) {
        viewState.value = state
    }

}
package es.example.presentation

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseFragment<STATE : Parcelable, TRANSITION>: Fragment() {

    private var netStatus : Boolean = false
    private val netObserver = Observer<Boolean> {
        netStatus = it
    }

    protected abstract val viewModel: BaseViewModel<STATE, TRANSITION>

    private var isInstanceSaved = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(getLayout(), container, false)



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        savedInstanceState?.getParcelable<STATE>("state")?.apply { viewModel.loadState(this) }
        isInstanceSaved = false
        initViews()
        initObservers()
        initListeners()
    }


    private fun init() {
        if (isAdded && !isInstanceSaved && !isRemoving) {
            initObservers()
            initListeners()
        }
    }

    protected abstract fun initViews()

    private fun initObservers() {
        viewModel.getViewState().observe(viewLifecycleOwner, Observer { manageState(it) })
        viewModel.getViewTransition().observe(viewLifecycleOwner, Observer { manageTransition(it) })
    }

    protected abstract fun manageState(state: STATE)

    protected abstract fun manageTransition(transition: TRANSITION)


    protected abstract fun initListeners()

    abstract fun getLayout(): Int


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.getViewState().value?.apply { outState.putParcelable("state", this) }
    }
}


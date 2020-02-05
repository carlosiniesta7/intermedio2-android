package com.example.presentation.view

import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.presentation.R
import es.example.presentation.BaseFragment
import es.example.presentation.BaseViewModel
import kotlinx.android.synthetic.main.fragment_viewpager.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ImagesPagerFragment : BaseFragment<ImagesPagerStates, ImagesPagerTransition>(){

    override val viewModel by viewModel <ImagesPagerViewModel>()

    override fun initViews() {
        view_pager2.adapter = ViewPagerAdapter()

        viewModel.getImages()
        viewModel._stateImages.observe(this, Observer {
            it?.let {
                (view_pager2.adapter as ViewPagerAdapter).refresh(it)
            }
        })

    }

    override fun manageState(state: ImagesPagerStates) {
    }

    override fun manageTransition(transition: ImagesPagerTransition) {
    }

    override fun initListeners() {
    }

    override fun getLayout(): Int {
        return R.layout.fragment_viewpager
    }
}
package com.example.presentation.view

import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.presentation.R
import es.example.presentation.BaseFragment
import es.example.presentation.BaseViewModel
import kotlinx.android.synthetic.main.fragment_viewpager.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ImagesPagerFragment(): BaseFragment<ImagesPagerStates, ImagesPagerTransition>(){

    override val viewModel by viewModel <ImagesPagerViewModel>()

    override fun initViews() {
        view_pager2.adapter = ViewPagerAdapter()

        viewModel.getImages()
        viewModel._stateImages.observe(this, Observer {
            it?.let {
                (view_pager2.adapter as ViewPagerAdapter).refresh(it)
            }
        })

        view_pager2.orientation = ViewPager2.ORIENTATION_VERTICAL
    }

    override fun manageState(state: ImagesPagerStates) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun manageTransition(transition: ImagesPagerTransition) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayout(): Int {
        return R.layout.fragment_viewpager
    }
}
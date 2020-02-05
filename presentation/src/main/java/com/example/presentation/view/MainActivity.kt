package com.example.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.presentation.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val MyViewModel by viewModel<MainViewModel>()
    var adapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        adapter = MainAdapter()

        rvElements?.adapter = adapter

        MyViewModel.stateTitle.observe(this, Observer {
            it?.let { title ->
                tvTitle?.text = title
            }
        })

        MyViewModel.stateList.observe(this, Observer {
            it?.let { elements ->
                adapter?.submitList(elements)
                adapter?.notifyDataSetChanged()
            }
        })

        MyViewModel.getElements()

//        bAddElement?.setOnClickListener {
//            MyViewModel.addElement()
//        }
    }
}

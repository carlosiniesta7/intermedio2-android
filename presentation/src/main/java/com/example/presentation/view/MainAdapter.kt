package com.example.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain2.model.Element
import com.example.presentation.R
import kotlinx.android.synthetic.main.activity_main_item.view.*

class MainAdapter : ListAdapter<Element, MainAdapter.MainVH>(
    ListElementsCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVH =
        MainVH(
            itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.activity_main_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MainVH, position: Int) {
        holder.bind(element = getItem(position))
    }

    inner class MainVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(element: Element) {
            itemView.tvItem?.text = element.name
        }
    }

    class ListElementsCallback : DiffUtil.ItemCallback<Element>() {
        override fun areItemsTheSame(oldItem: Element, newItem: Element): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Element, newItem: Element): Boolean {
            return oldItem.name == newItem.name
        }
    }

}
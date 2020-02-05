package com.example.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain2.model.Element
import com.example.presentation.R
import com.example.presentation.view.viewEntities.ElementViewEntity
import kotlinx.android.synthetic.main.activity_main_item.view.*

class MainAdapter(var listener: OnItemClickListener) : ListAdapter<ElementViewEntity, MainAdapter.MainVH>(
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
        fun bind(element: ElementViewEntity) {
            itemView.tvTitle?.text = element.name
            itemView.tvDescription?.text = element.description

            itemView.setOnClickListener {
                listener.onItemClick(element.name, element.description)
            }
        }
    }

    class ListElementsCallback : DiffUtil.ItemCallback<ElementViewEntity>() {
        override fun areItemsTheSame(oldItem: ElementViewEntity, newItem: ElementViewEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ElementViewEntity, newItem: ElementViewEntity): Boolean {
            return oldItem.name == newItem.name
        }
    }

    interface OnItemClickListener{
        fun onItemClick(name: String, description: String)
    }
}
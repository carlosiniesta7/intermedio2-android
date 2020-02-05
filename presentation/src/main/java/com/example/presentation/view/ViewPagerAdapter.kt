package com.example.presentation.view


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.R
import kotlinx.android.synthetic.main.item_page_viewpager.view.*

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    private val images = mutableListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_page_viewpager,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(images[position])
    }

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

        fun bind(image: Int) = with(itemView) {
            ivImage.setImageResource(image)
        }
    }



    fun refresh(_images:List<Int>){
        images.clear()
        images.addAll(_images)
        notifyDataSetChanged()
    }

}
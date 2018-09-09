package me.thuongle.daggersample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.thuongle.daggersample.R

class ItemAdapter : ListAdapter<Long, ItemAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvDescription = itemView.findViewById<TextView>(R.id.tv_description)!!

        fun bind(item: Long) {
            tvDescription.text = item.toString()
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Long>() {
            override fun areContentsTheSame(oldItem: Long, newItem: Long) = (oldItem == newItem)

            override fun areItemsTheSame(oldItem: Long, newItem: Long) = (oldItem == newItem)
        }
    }
}

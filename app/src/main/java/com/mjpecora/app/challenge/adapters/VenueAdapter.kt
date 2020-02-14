package com.mjpecora.app.challenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mjpecora.app.challenge.BR
import com.mjpecora.app.challenge.R
import com.mjpecora.app.challenge.model.Data

class VenueAdapter : ListAdapter<Data, VenueAdapter.VenueViewHolder>(DiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_venue
    }

    override fun onBindViewHolder(holder: VenueViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), viewType, parent, false)
        return VenueViewHolder(binding)
    }

    class VenueViewHolder(private val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Data) {
            binding.setVariable(BR.data, item)
            binding.executePendingBindings()
        }

    }

    class DiffCallback: DiffUtil.ItemCallback<Data>() {
        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.name == newItem.name
        }
    }

}
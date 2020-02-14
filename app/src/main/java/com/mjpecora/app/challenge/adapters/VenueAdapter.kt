package com.mjpecora.app.challenge.adapters

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mjpecora.app.challenge.BR
import com.mjpecora.app.challenge.R
import com.mjpecora.app.challenge.model.Data
import com.mjpecora.app.challenge.utils.BASE_URL


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
            val url = String.format(BASE_URL, item.url)
            val i = item.copy().apply {
                this.listener = View.OnClickListener {
                    Log.d("Adapter", url)
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(binding.root.context, intent, null)
                }
            }
            binding.setVariable(BR.data, i)
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
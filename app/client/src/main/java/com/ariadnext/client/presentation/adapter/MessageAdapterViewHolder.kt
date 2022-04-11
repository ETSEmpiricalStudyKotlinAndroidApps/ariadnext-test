package com.ariadnext.client.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ariadnext.client.databinding.AdapterClientItemBinding
import com.ariadnext.client.databinding.AdapterServerItemBinding
import com.ariadnext.client.presentation.models.MessageData

/**
 *  Base View holder.
 */
sealed class MessageAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindView(item: MessageData)
}


/**
 * View holder for server.
 */
class MessageServerViewHolder(private var binding: AdapterServerItemBinding) : MessageAdapterViewHolder(binding.root) {
    override fun bindView(item: MessageData) {
        binding.data = item

    }
}

/**
 * View holder for client.
 */
class MessageClientViewHolder(private var binding: AdapterClientItemBinding) : MessageAdapterViewHolder(binding.root) {
    override fun bindView(item: MessageData) {
        binding.data = item
    }
}
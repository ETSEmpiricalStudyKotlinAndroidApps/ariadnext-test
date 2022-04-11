package com.ariadnext.client.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ariadnext.client.databinding.AdapterClientItemBinding
import com.ariadnext.client.databinding.AdapterServerItemBinding
import com.ariadnext.client.presentation.extension.getLayoutInflater
import com.ariadnext.client.presentation.models.MessageData

/**
 * Chat message adapter.
 * */
class MessageAdapter : ListAdapter<MessageData, MessageAdapterViewHolder>(DIFF_UTIL) {
    override fun getItemViewType(position: Int) = getItem(position).type

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageAdapterViewHolder {
        return if (viewType == MessageData.CLIENT) {
            MessageClientViewHolder(AdapterClientItemBinding.inflate(parent.getLayoutInflater()))
        } else {
            MessageServerViewHolder(AdapterServerItemBinding.inflate(parent.getLayoutInflater()))
        }
    }

    override fun onBindViewHolder(holder: MessageAdapterViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    companion object {
        /** Diff helper. */
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<MessageData>() {
            override fun areItemsTheSame(oldItem: MessageData, newItem: MessageData) = (oldItem == newItem)
            override fun areContentsTheSame(oldItem: MessageData, newItem: MessageData) = (oldItem.id == newItem.id)
        }
    }


}


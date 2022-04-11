package com.ariadnext.client.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import com.ariadnext.client.databinding.ActivityMainBinding
import com.ariadnext.client.presentation.adapter.MessageAdapter
import com.ariadnext.client.presentation.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

/**
 * The main activity.
 * */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {

            val messageAdapter = MessageAdapter()
            val mainViewModel: MainActivityViewModel by viewModels()

            mainActivityRecyclerChat.adapter = messageAdapter

            lifecycle.coroutineScope.launchWhenCreated {
                mainViewModel.chatListFlow.collect {
                    messageAdapter.submitList(it.toList())
                    mainActivityRecyclerChat.smoothScrollToPosition(it.size)
                }
            }

            mainChatSendMessageButton.setOnClickListener {
                mainViewModel.sendMessage(mainChatMessageEditText.text.toString())
                mainChatMessageEditText.setText("")
            }

            setContentView(root)
        }
    }

}

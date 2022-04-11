package com.ariadnext.client.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ariadnext.client.presentation.models.MessageData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(

) : ViewModel() {

    /** Chat list. */
    private var chatListMessage: ArrayList<MessageData> = arrayListOf()

    /** Chat list data state flow. */
    private val _chatListFlow = MutableStateFlow<List<MessageData>>(emptyList())

    /** Internal chat list data state flow. */
    val chatListFlow: StateFlow<List<MessageData>>
        get() = _chatListFlow

    
    /**
     * SendMessage to server.
     * @param messageText the message text.
     * */

    fun sendMessage(messageText: String) {
        viewModelScope.launch {
            val currentMessage = MessageData(
                messageText = messageText,
                id = Date().time.toString(),
                isSeen = false,
                type = MessageData.CLIENT,

                )
            chatListMessage.add(currentMessage)
            _chatListFlow.emit(chatListMessage.toList())

        }
    }

}
package com.ariadnext.client.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ariadnext.server.data.models.MessageData
import com.ariadnext.server.domain.usecases.InitClientServerChannelUseCase
import com.ariadnext.server.domain.usecases.RetrieveFromServerUseCase
import com.ariadnext.server.domain.usecases.SendToServerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val sendToServerUseCase: SendToServerUseCase,
    private val retrieveFromServerUseCase: RetrieveFromServerUseCase,
    private val initClientServerChannel: InitClientServerChannelUseCase,
) : ViewModel() {

    /** Chat list. */
    private var chatListMessage: ArrayList<MessageData> = arrayListOf()

    /** Chat list data state flow. */
    private val _chatListFlow = MutableStateFlow<List<MessageData>>(emptyList())

    /** Internal chat list data state flow. */
    val chatListFlow: StateFlow<List<MessageData>>
        get() = _chatListFlow

    init {
        viewModelScope.launch {
            retrieveFromServerUseCase.invoke().collect { result ->
                val editList = chatListMessage.map {
                    when (it.id) {
                        result.keys.first() -> it.copy(isSeen = true)
                        else -> it
                    }
                }

                chatListMessage = editList as ArrayList<MessageData>
                chatListMessage.add(result.values.first())
                _chatListFlow.emit(chatListMessage.toList())
            }
        }
        viewModelScope.launch {
            initClientServerChannel.invoke()
        }


    }

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
            sendToServerUseCase.invoke(currentMessage)

        }
    }

}
package com.ariadnext.server.data.repository

import android.content.Context
import android.widget.Toast
import com.ariadnext.server.R
import com.ariadnext.server.data.models.MessageData
import com.ariadnext.server.domain.repository.ServerRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import java.util.Date
import javax.inject.Inject

/**
 * Server repository implementation.
 * */
class ServerRepositoryImpl @Inject constructor(
    @ApplicationContext val context: Context
) : ServerRepository {
    private val clientMessageFlow = MutableSharedFlow<MessageData>()
    private val serverResponseFlow = MutableSharedFlow<Map<String, MessageData>>()

    /**
     * Retrieve client message.
     * @param sendMessage
     * */
    override suspend fun retrieveClientMessage(sendMessage: MessageData) {
        clientMessageFlow.emit(sendMessage)
    }

    /**
     * ClientServerChannel.
     * */
    override suspend fun clientServerChannel() {
        var responseTimer = TIMER_MIN_VALUE
        clientMessageFlow.onEach {
            Toast.makeText(
                context,
                context.getString(R.string.response_timer, (responseTimer / 1000).toString()),
                Toast.LENGTH_LONG
            ).show()
            delay(responseTimer.toLong())
        }
            .collect {
                val currentMessage = MessageData(
                    messageText = context.getString(R.string.response_for, it.messageText),
                    id = Date().time.toString(),
                    isSeen = false,
                    type = MessageData.SERVER,
                )
                sendResponseForClient(it.id, currentMessage)
                responseTimer = (TIMER_MIN_VALUE..TIMER_MAX_VALUE).random()

            }
    }

    /**
     * SendResponseForClient.
     * @param messageId the message id to put it in map to update client message.
     * @param responseMessageData the server message.
     * */
    private suspend fun sendResponseForClient(messageId: String, responseMessageData: MessageData) {
        serverResponseFlow.emit(mapOf(messageId to responseMessageData))
    }

    /**
     * ServerResponseChannel.
     * */
    override suspend fun serverResponseChannel(): MutableSharedFlow<Map<String, MessageData>> {
        return serverResponseFlow
    }

    companion object {
        const val TIMER_MIN_VALUE = 3000
        const val TIMER_MAX_VALUE = 9000
    }
}
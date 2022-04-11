package com.ariadnext.server.domain.repository

import com.ariadnext.server.data.models.MessageData
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * Server repository.
 * */
interface ServerRepository {

    suspend fun retrieveClientMessage(sendMessage: MessageData)
    suspend fun clientServerChannel()
    suspend fun serverResponseChannel(): MutableSharedFlow<Map<String, MessageData>>
}
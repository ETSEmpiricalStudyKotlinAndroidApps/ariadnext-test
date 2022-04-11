package com.ariadnext.server.domain.usecases

import com.ariadnext.server.data.models.MessageData
import com.ariadnext.server.domain.repository.ServerRepository
import javax.inject.Inject

class SendToServerUseCase @Inject constructor(
    private val serverRepository: ServerRepository,
) {
    suspend operator fun invoke(messageData: MessageData) = serverRepository.retrieveClientMessage(messageData)
}
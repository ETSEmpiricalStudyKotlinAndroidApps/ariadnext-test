package com.ariadnext.server.domain.usecases

import com.ariadnext.server.domain.repository.ServerRepository
import javax.inject.Inject

class RetrieveFromServerUseCase @Inject constructor(
    private val serverRepository: ServerRepository,
) {
    suspend operator fun invoke() = serverRepository.serverResponseChannel()
}

package com.ariadnext.server.data.models

/**
 * Message data related to data object.
 * */
data class MessageData(
    /**Message Id.*/
    val id: String,

    /**Message Text.*/
    val messageText: String,
    /**Message is Seen.*/
    val isSeen: Boolean,
    /**Message type.*/
    val type: Int,

    ) {
    companion object {
        /** Client type. */
        const val CLIENT = 1

        /** Server type. */
        const val SERVER = 2
    }
}

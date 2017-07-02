package com.github.ivan_osipov.clabo.state.chat

import com.github.ivan_osipov.clabo.utils.ChatId
import examples.buyartbot.ChatState

abstract class AbstractChatStateInMemoryStore<T : ChatState<C>, C : ChatContext> : ChatStateStore<C> {

    protected val chatStateMap: MutableMap<ChatId, T> = HashMap()

    override fun updateContext(chatId: ChatId, chatContext: C) {
        chatStateMap.putIfAbsent(chatId, createChatState(chatId))
        val state = chatStateMap[chatId]!!
        state.context = chatContext
    }

    override fun getChatContext(chatId: ChatId) : C {
        chatStateMap.putIfAbsent(chatId, createChatState(chatId))
        val state = chatStateMap[chatId]!!
        return state.context
    }

    abstract fun createChatState(chatId: ChatId) : T

}
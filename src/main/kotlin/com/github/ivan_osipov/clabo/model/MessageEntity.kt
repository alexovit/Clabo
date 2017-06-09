package com.github.ivan_osipov.clabo.model

import com.github.ivan_osipov.clabo.exceptions.IncorrectApiUsage
import com.github.ivan_osipov.clabo.utils.notOneOf
import com.google.gson.annotations.SerializedName
import kotlin.properties.Delegates

class MessageEntity {

    @SerializedName("type")
    private lateinit var _type: String

    val type: Type = Type.valueOf(_type)

    var offset: Int by Delegates.notNull()

    var length: Int by Delegates.notNull()

    var url: String? = null
        get() {
            if(type.notOneOf(Type.TEXT_LINK)) {
                throw IncorrectApiUsage("Type ${type.name} doesn't support url")
            }
            return field
        }

    var user: User? = null
        get() {
            if(type.notOneOf(Type.TEXT_MENTION)) {
                throw IncorrectApiUsage("Type ${type.name} doesn't support user")
            }
            return field
        }


    enum class Type(name: String) {
        MENTION("mention"),
        HASHTAG("hashtag"),
        BOT_COMMAND("bot_command"),
        URL("url"),
        EMAIL("email"),
        BOLD("bold"),
        ITALIC("italic"),
        CODE("code"),
        PRE("pre"),
        TEXT_LINK("text_link"),
        TEXT_MENTION("text_mention")
    }
}
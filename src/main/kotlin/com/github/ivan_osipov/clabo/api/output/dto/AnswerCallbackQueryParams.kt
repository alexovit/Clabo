package com.github.ivan_osipov.clabo.api.output.dto

import com.github.ivan_osipov.clabo.utils.Text

/**
 * docs https://core.telegram.org/bots/api#answercallbackquery
 */
open class AnswerCallbackQueryParams(
        val callbackQueryId: String,
        var text: Text? = null,
        var showAlert: Boolean = false,
        var cacheTime: Int? = null) : OutputParams {
    override fun toListOfPairs(): MutableList<Pair<String, *>> {
        return mutableListOf("callback_query_id" to callbackQueryId,
                "text" to text,
                "show_alert" to showAlert,
                "cache_time" to cacheTime
        )
    }
}
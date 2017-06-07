package com.github.ivan_osipov.clabo.model

import com.google.gson.annotations.SerializedName

/**
 * @see <a href="https://core.telegram.org/bots/api#contact">docs</a>
 */
class Contact {
    @SerializedName("first_name")
    lateinit var firstName: String

    @SerializedName("phone_number")
    lateinit var phoneNumber: String

    @SerializedName("last_name")
    var lastName: String? = null

    @SerializedName("user_id")
    var usedId: Int? = null
}
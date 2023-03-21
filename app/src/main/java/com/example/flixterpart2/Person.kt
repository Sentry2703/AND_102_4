package com.example.flixterpart2

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Keep
@Serializable
data class Response(
    @SerialName("results")
    val response: List<Person>?
)

@Keep
@Serializable
data class Person(
    @SerialName("profile_path")
    val image: String?,

    @SerialName("adult")
    val adult: Boolean?,

    @SerialName("name")
    val name: String?,

    @SerialName("known_for")
    val otherDetails: List<OneOf>?

) : java.io.Serializable {
    val titleT = otherDetails?.firstOrNull {it.title != null}?.title ?: ""
    val descriptionT = otherDetails?.firstOrNull { it.description != null }?.description ?: ""
    val titleU = otherDetails?.firstOrNull {it.titleb != null}?.titleb ?: ""
    val titleV = otherDetails?.firstOrNull {it.titlec != null}?.titlec ?: ""
    val titleW = otherDetails?.firstOrNull {it.titled != null}?.titled ?: ""
    val poster = otherDetails?.firstOrNull {it.poster != null}?. poster ?: ""
}


@Keep
@Serializable
data class OneOf @JvmOverloads constructor(
    @SerialName("original_title")
    var title: String? = "BlankA",

    @SerialName("title")
    var titleb: String? = "BlankB",

    @SerialName("overview")
    val description: String?,

    @SerialName("name")
    var titlec : String? = "BlankC",

    @SerialName("original_name")
    var titled: String? = "BlankD",

    @SerialName("poster_path")
    var poster: String?,
) : java.io.Serializable



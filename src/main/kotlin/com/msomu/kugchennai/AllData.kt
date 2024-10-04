package com.msomu.kugchennai

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

@OptIn(ExperimentalSerializationApi::class)
val jsonData : Data by lazy {
    Data::class.java.classLoader.getResourceAsStream("all-data.json")!!.use {
        Json.decodeFromStream(it)
    }
}

@Serializable
data class Data(
    val agendas: List<Agendas>,
    val announcements: List<String>,
    val rooms: List<Rooms>,
    val communityPartners: List<CommunityPartner>,
    val memories: List<Memory>
)

@Serializable
data class Agendas(
    val imageUrls: List<String>,
    val name: String,
    val session: String,
    val showImage: Boolean,
    val showMultipleImage: Boolean,
    val time: String,
    private val roomId : String,
){
    fun rooms() = jsonData.rooms.filter { it.roomId == roomId }
}

@Serializable
data class CommunityPartner(
    val image: String,
    val link: String,
    val title: String
)

@Serializable
data class Rooms(
    val roomId : String,
    val roomName : String
)

@Serializable
data class Memory(
    val image: String,
    val title: String
)
package com.example.flocator.main.models.dto

import com.example.flocator.common.storage.db.entities.Mark
import com.example.flocator.common.storage.db.entities.MarkPhoto
import com.example.flocator.common.storage.db.entities.MarkWithPhotos
import com.example.flocator.main.ui.main.data.PointDto
import com.google.gson.annotations.SerializedName
import com.yandex.mapkit.geometry.Point
import java.sql.Timestamp

data class MarkDto(

    @SerializedName("markId")
    val markId: Long,

    @SerializedName("authorId")
    val authorId: Long,

    @SerializedName("point")
    val location: PointDto,

    @SerializedName("text")
    val text: String,

    @SerializedName("isPublic")
    val isPublic: Boolean,

    @SerializedName("photos")
    val photos: List<String>,

    @SerializedName("place")
    val place: String,

    @SerializedName("likesCount")
    var likesCount: Int,

    @SerializedName("hasUserLiked")
    var hasUserLiked: Boolean,

    @SerializedName("createdAt")
    val createdAt: Timestamp
): java.io.Serializable {
    fun toMarkWithPhotos(): MarkWithPhotos {
        val markPhotos = photos.map {
            MarkPhoto(
                it,
                markId
            )
        }
        return MarkWithPhotos(
            Mark(
                markId,
                authorId,
                Point(
                    location.latitude,
                    location.longitude
                ),
                text,
                isPublic,
                place,
                likesCount,
                hasUserLiked,
                createdAt
            ),
            markPhotos
        )
    }
}
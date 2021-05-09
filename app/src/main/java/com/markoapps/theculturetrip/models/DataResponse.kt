package com.markoapps.theculturetrip.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ArticleResponse (
    @SerializedName("data")val data: List<Article>
    ) : Serializable

data class Article (
    @SerializedName("metaData")val metaData: ItemMetaData,
    @SerializedName("id")val id: String,
    @SerializedName("title")val title: String,
    @SerializedName("imageUrl")val imageUrl: String,
    @SerializedName("isSaved")val isSaved: Boolean,
    @SerializedName("isLiked")val isLiked: Boolean,
    @SerializedName("likesCount")val likesCount: Int,
    @SerializedName("category")val category: String,
    @SerializedName("author")val author: Author

) : Serializable

data class ItemMetaData (
    @SerializedName("currentTime")val currentTime: String,
    @SerializedName("updateTime")val updateTime: String
    )  : Serializable

data class Author (
    @SerializedName("id")val id: String,
    @SerializedName("authorName")val authorName: String,
    @SerializedName("authorAvatar")val authorAvatar: AuthorAvatar
        )  : Serializable

data class AuthorAvatar (
    @SerializedName("imageUrl") val imageUrl: String
) : Serializable
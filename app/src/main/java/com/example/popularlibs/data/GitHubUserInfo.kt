package com.example.popularlibs.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUserInfo(
    @SerializedName("login")
    val login: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("node_id")
    val nodeId: String? = null,
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @SerializedName("events_url")
    val eventsUrl: String? = null,
    @SerializedName("received_events_url")
    val receivedEventsUrl: String? = null,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("site_admin")
    val siteAdmin: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("location")
    val location: String = "",
    @SerializedName("bio")
    val bio: String? = null,
    @SerializedName("twitter_username")
    val twitterUsername: String = "",
    @SerializedName("public_repos")
    val publicRepos: String = "",
    @SerializedName("created_at")
    val createdAt: String = ""
) : Parcelable

package com.example.popularlibs.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "GitHubUserReposTable")
data class GitHubUserRepos(

    @PrimaryKey
    @ColumnInfo
    @SerializedName("id")
    val id: String,

    @ColumnInfo
    @SerializedName("node_id")
    val nodeId: String = "",

    @ColumnInfo
    @SerializedName("name")
    val name: String = "",

    @ColumnInfo
    @SerializedName("full_name")
    val fullName: String = "",

    @ColumnInfo
    @SerializedName("html_url")
    val htmlUrl: String = ""

) : Parcelable

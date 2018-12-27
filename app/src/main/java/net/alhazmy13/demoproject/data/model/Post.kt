package net.alhazmy13.demoproject.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author CIPL0349
 * @created 21/05/18
 */
data class Post(
    @SerializedName("userId")
    val userId: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("body")
    val body: String = "")
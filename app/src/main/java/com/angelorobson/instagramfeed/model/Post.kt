package com.angelorobson.instagramfeed.model

data class Post(
    val userImage: Int,
    val username: String,
    val imagePost: Int,
    val likeTo: String,
    val description: String,
    val imageCommentUser: Int,
    val postTime: String
)
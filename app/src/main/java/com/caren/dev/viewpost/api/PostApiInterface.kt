package com.caren.dev.viewpost.api

//class PostApiInterface {
//}

import com.caren.dev.viewpost.model.Post
import com.caren.dev.viewpost.ui.Comments
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface PostApiInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("/posts/{postId}")
    fun fetchPostById(@Path("postId") postId:Int):Call<Post>

    @GET("/posts/{postId}/comments")
    fun fetchCommentsByPostId(@Path("postId") postId:Int):Call<List<Comments>>
}
package com.caren.dev.viewpost.repository

import com.caren.dev.viewpost.api.Apiclient
import com.caren.dev.viewpost.api.PostApiInterface
import com.caren.dev.viewpost.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class PostsRepository {
    val apiClient = Apiclient.buildApiClient(PostApiInterface::class.java)

    suspend fun fetchPosts():Response<List<Post>>{
        return withContext(Dispatchers.IO){
            apiClient.getPosts()
        }

    }
    suspend fun fetchPostById(postId: Int): Call<Post> {
        return withContext(Dispatchers.IO){
            apiClient.fetchPostById(postId)
        }
    }

}
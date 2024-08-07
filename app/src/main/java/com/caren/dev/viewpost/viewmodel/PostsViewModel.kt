package com.caren.dev.viewpost.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caren.dev.viewpost.model.Post
import com.caren.dev.viewpost.repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel:ViewModel() {
    val postsRepo = PostsRepository()
    val postsLiveData=MutableLiveData<List<Post>>()
    val errorLiveData = MutableLiveData<String>()
    val postLiveData = mutableLiveData<Post>()

    fun fetchPosts(){
        viewModelScope.launch {
            val response = postsRepo.fetchPosts()
            if (response.isSucceful){
                postsLiveData.postValue(response.body())
            }
        }
        else{
            errorLiveData.postValue(response.errorBody()?.string())
        }
    }
    fun fetchPostById(postId: Int){
viewModelScope.launch {
    val response = postsRepo.fetchPostById(postId)
    if (response.isSuccessful){
        postLiveData.postValue(response.body())
    }
    else{
        errorLiveData.postValue(response.errorBody()?.string())
    }
}
    }
}
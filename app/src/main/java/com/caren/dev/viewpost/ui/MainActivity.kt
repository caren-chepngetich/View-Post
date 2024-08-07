package com.caren.dev.viewpost.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.caren.dev.viewpost.api.Apiclient
import com.caren.dev.viewpost.api.PostApiInterface
import com.caren.dev.viewpost.databinding.ActivityMainBinding
import com.caren.dev.viewpost.model.Post
import com.caren.dev.viewpost.repository.AdapterPost
import com.caren.dev.viewpost.viewmodel.PostsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val postsViewModel : PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvRecycler.layoutManager = LinearLayoutManager(this)

    }


    override  fun onResume(){
                super.onResume()
        PostsViewModel.postsLiveData.observe(this){
            posts
        }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }
fun displayPosts(posts:List<Post>)
}




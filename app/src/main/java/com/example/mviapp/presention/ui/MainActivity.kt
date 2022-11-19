package com.example.mviapp.presention.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mviapp.R
import com.example.mviapp.domain.model.User
import com.example.mviapp.presention.adapter.UserAdapter
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.ComponentActivity.ACTIVITY_SERVICE
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mviapp.databinding.ActivityMainBinding
import com.example.mviapp.presention.Effect
import com.example.mviapp.presention.Event
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var userAdapter: UserAdapter
    val viewmodel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater )
        val view = binding.root
        setContentView(view)

        viewmodel.onIntent(Event.fetchUser)
        lifecycleScope.launchWhenCreated {
            userAdapter = UserAdapter()
            viewmodel.uiState.collectLatest {
                userAdapter = UserAdapter()
                binding.recycleview.apply {
                    adapter = userAdapter
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }
                userAdapter.UserList = it.listUser
            }
        }

            binding.retryButton.setOnClickListener {
                viewmodel.onIntent(Event.Retry)
            }
            binding.thrownButton.setOnClickListener {
                Log.i("Click","ButtonClicked")
                viewmodel.onIntent(Event.RequestThrownException)
            }
            binding.navigateButton.setOnClickListener {
                viewmodel.onIntent(Event.Navigate)
            }



        lifecycleScope.launchWhenCreated {
            viewmodel.effect.collectLatest {
                when (it) {
                    is Effect.NavigateToDetailsScreen -> {
                        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                        startActivity(intent)
                    }
                    is Effect.ShowSnackBarErrorMessage -> {
                 //       Snackbar.make(binding.button2, it.message, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }




    }
}
package com.example.fetchapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchapp.adapters.ParentAdapter
import com.example.fetchapp.databinding.ActivityMainBinding
import com.example.fetchapp.utils.Helper
import com.example.fetchapp.utils.ScreenState
import com.example.fetchapp.viewmodels.FetchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel :FetchViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = ParentAdapter()

       binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter


        viewModel.getItems()

        viewModel.items.observe(this) { state ->
            when (state) {
                is ScreenState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
                is ScreenState.Success -> {
                    binding.progressBar.visibility = View.GONE
                   binding.recyclerView.visibility = View.VISIBLE
                    val data = state.data
                    val items = Helper.fromItemListToCollapsableListItem(data!!)
                    adapter.differ.submitList(items)
                }
                is ScreenState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                    Toast.makeText(this, state.message, Toast.LENGTH_LONG).show()
                }

                else -> {}
            }
        }




    }


}

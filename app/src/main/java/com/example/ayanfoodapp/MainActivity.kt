package com.example.ayanfoodapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayanfoodapp.adapter.FoodAdapter
import com.example.ayanfoodapp.databinding.ActivityMainBinding
import com.example.ayanfoodapp.model.FoodModelItem
import com.example.ayanfoodapp.repository.FoodRepository
import com.example.ayanfoodapp.viewmodel.MainViewModel
import com.example.ayanfoodapp.viewmodelfactory.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    val data: ArrayList<FoodModelItem> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
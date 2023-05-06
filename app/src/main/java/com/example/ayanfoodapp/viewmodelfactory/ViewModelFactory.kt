package com.example.ayanfoodapp.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ayanfoodapp.repository.FoodRepository
import com.example.ayanfoodapp.viewmodel.MainViewModel

class MainViewModelFactory(private val repository: FoodRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}
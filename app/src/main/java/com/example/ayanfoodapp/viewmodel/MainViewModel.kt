package com.example.ayanfoodapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ayanfoodapp.model.FoodModel
import com.example.ayanfoodapp.model.requestModel.Posts
import com.example.ayanfoodapp.repository.FoodRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    private val mainRepository: FoodRepository
):ViewModel() {
    val myPushResponse:MutableLiveData<Response<FoodModel>> = MutableLiveData()

    fun pushPost(apiKey:String,ingredients:String,limitLicense:Boolean,ranking:Int,ignorePantry:Boolean,number:Int){
        viewModelScope.launch {
            val response = mainRepository.pushPosts(apiKey, ingredients,number, limitLicense, ranking, ignorePantry)
            myPushResponse.value = response
        }
    }
}
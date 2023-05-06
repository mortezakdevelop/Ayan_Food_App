package com.example.ayanfoodapp.repository

import com.example.ayanfoodapp.model.FoodModel
import com.example.ayanfoodapp.model.requestModel.Posts
import com.example.ayanfoodapp.network.RetrofitInstance
import retrofit2.Response

class FoodRepository {

    suspend fun pushPosts(apiKey:String,ingredients:String,number:Int,limitLicense:Boolean,ranking:Int,ignorePantry:Boolean):Response<FoodModel>{
        return RetrofitInstance.api.pushPost(apiKey,ingredients, number, limitLicense, ranking, ignorePantry)
    }
}
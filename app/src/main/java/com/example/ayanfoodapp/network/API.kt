package com.example.ayanfoodapp.network

import com.example.ayanfoodapp.model.FoodModel
import com.example.ayanfoodapp.model.requestModel.Posts
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface API {

    @GET("recipes/findByIngredients")
    suspend fun pushPost(
        @Query("apiKey") apiKey:String,
        @Query("ingredients") ingredients:String,
        @Query("number") number:Int,
        @Query("limitLicense") limitLicense:Boolean,
        @Query("ranking") ranking:Int,
        @Query("ignorePantry") ignorePantry:Boolean,


    ):Response<FoodModel>
}
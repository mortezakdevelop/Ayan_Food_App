package com.example.ayanfoodapp.model.requestModel

data class Posts(
    val apiKey:String,
    val ingredients:String,
    val number:Int,
    val limitLicense:Boolean,
    val ranking:Int,
    val ignorePantry:Int
)
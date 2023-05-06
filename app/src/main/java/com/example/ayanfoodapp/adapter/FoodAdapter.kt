package com.example.ayanfoodapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ayanfoodapp.R
import com.example.ayanfoodapp.databinding.RowFoodItemBinding
import com.example.ayanfoodapp.model.FoodModelItem

class FoodAdapter(private var data: ArrayList<FoodModelItem>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private val myList = emptyList<FoodModelItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {

        val rowFoodItemBinding: RowFoodItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_food_item, parent, false
        )
        return FoodViewHolder(rowFoodItemBinding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun addData(newData: ArrayList<FoodModelItem>) {
        data = newData
        notifyDataSetChanged()
    }

    inner class FoodViewHolder(private val binding: RowFoodItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodModelItem: FoodModelItem) {
            binding.titleTv.text = foodModelItem.title
            binding.missedIngredientTv.text = foodModelItem.missedIngredientCount.toString()

            Glide.with(binding.root.context).load(foodModelItem.image).into(binding.foodImg)
        }
    }

}
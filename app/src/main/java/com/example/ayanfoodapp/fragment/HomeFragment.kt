package com.example.ayanfoodapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ayanfoodapp.R
import com.example.ayanfoodapp.adapter.FoodAdapter
import com.example.ayanfoodapp.databinding.FragmentHomeBinding
import com.example.ayanfoodapp.model.FoodModelItem
import com.example.ayanfoodapp.repository.FoodRepository
import com.example.ayanfoodapp.viewmodel.MainViewModel
import com.example.ayanfoodapp.viewmodelfactory.MainViewModelFactory

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    val data: ArrayList<FoodModelItem> = ArrayList()
    private val adapter by lazy { FoodAdapter(data) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        val repository = FoodRepository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        requestPostFoods()


        viewModel.myPushResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                binding.tvResponse.text = response.body().toString()
            }
        })
        return layoutInflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun requestPostFoods() {
        val ingredients = "carrots,tomatoes"
        val number = 10
        val limitLicense = true
        val ranking = 1
        val ignorePantry = false
        val apiKey = "0dd72edcd6594da9a4ac5b71a2122caf"

        viewModel.pushPost(apiKey, ingredients, limitLicense, ranking, ignorePantry, number)
    }
}

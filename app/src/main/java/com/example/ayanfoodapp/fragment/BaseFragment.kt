package com.example.ayanfoodapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.ayanfoodapp.MainActivity
import com.example.ayanfoodapp.viewmodel.MainViewModel

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T
    lateinit var mainBinding: ViewBinding
    fun getMainActivity() = requireActivity() as MainActivity
    lateinit var viewModel: MainViewModel


    @Suppress("UNCHECKED_CAST")
    protected val binding: T
        get() = mainBinding as T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun accessViews(block: T.() -> Unit) {
        binding.apply {
            block()
        }
    }

    fun makeToast(message:String){
        Toast.makeText(requireContext(),message,Toast.LENGTH_LONG).show()
    }



}
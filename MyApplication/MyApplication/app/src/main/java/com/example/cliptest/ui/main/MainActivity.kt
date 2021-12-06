package com.example.cliptest.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.cliptest.R
import com.example.cliptest.databinding.ActivityMainBinding
import com.example.cliptest.ui.main.MainViewModel


class MainActivity : AppCompatActivity() {

    var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        supportActionBar?.hide()

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel
        binding.executePendingBindings()

        mainViewModel!!.navController = Navigation.findNavController(
            this, R.id.listContainer
        )
    }
}
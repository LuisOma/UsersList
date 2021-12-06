package com.example.cliptest.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cliptest.R
import com.example.cliptest.databinding.FragmentProfileBinding
import com.example.cliptest.ui.main.MainViewModel
import com.squareup.picasso.Picasso
import android.content.Intent
import android.net.Uri
import jp.wasabeef.picasso.transformations.CropCircleTransformation


class ProfileFragment: Fragment() {

    private var mainViewModel: MainViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentProfileBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        mainViewModel =
            activity?.let { ViewModelProvider(it).get(MainViewModel::class.java) }

        binding.viewModel = mainViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        Picasso.get().load(mainViewModel?.selectedUser?.value?.picture?.large)
            .transform(CropCircleTransformation())
            .into(binding.profilePicture)

        binding.locationLayout.setOnClickListener {
            launchLocationMap()
        }

        return binding.root
    }

    private fun launchLocationMap(){
        val gmmIntentUri = Uri.parse("geo:${mainViewModel?.selectedUser?.value?.location?.coordinates?.latitude},${mainViewModel?.selectedUser?.value?.location?.coordinates?.longitude}")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}
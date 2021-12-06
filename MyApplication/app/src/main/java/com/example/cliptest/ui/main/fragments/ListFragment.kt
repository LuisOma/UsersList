package com.example.cliptest.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cliptest.R
import com.example.cliptest.databinding.FragmentListBinding
import com.example.cliptest.domain.model.Result
import com.example.cliptest.ui.main.MainViewModel
import com.example.cliptest.ui.main.adapter.UserAdapter

class ListFragment : Fragment(), UserAdapter.AdapterClickListener {

    private var mainViewModel: MainViewModel? = null
    lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)

        mainViewModel =
            activity?.let { ViewModelProvider(it).get(MainViewModel::class.java) }

        binding.viewModel = mainViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        mainViewModel?.setCurrentUser(null)

        initRecycler(binding)


        mainViewModel?.users?.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                binding.loadingLot.visibility = View.GONE
                binding.title.visibility = View.VISIBLE
                adapter.updateInfo(it.toTypedArray())
            }else{
                binding.loadingLot.visibility = View.VISIBLE
                binding.title.visibility = View.GONE
            }
        })
        if(mainViewModel?.users?.value.isNullOrEmpty())
        getInfo()

        binding.fabScroll.setOnClickListener {
            binding.usersRecycler.post {
                binding.usersRecycler.smoothScrollToPosition(0)
            }
        }
        return binding.root
    }

    private fun initRecycler(binding: FragmentListBinding) {
        binding.usersRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = UserAdapter()
        adapter.setClickListener(this)
        binding.usersRecycler.adapter = adapter

        binding.usersRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    binding.fabScroll.show()
                } else {
                    binding.fabScroll.hide()
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun getInfo() {
        mainViewModel?.getUsers()
    }

    override fun onItemSelected(user: Result?) {
        mainViewModel?.setCurrentUser(user)
        mainViewModel?.navController?.navigate(R.id.action_listFragment_to_profileFragment)
    }
}
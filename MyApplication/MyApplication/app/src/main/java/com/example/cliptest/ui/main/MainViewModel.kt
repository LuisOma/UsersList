package com.example.cliptest.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.cliptest.domain.model.Result
import com.example.cliptest.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    var navController: NavController? = null
    val selectedUser = MutableLiveData<Result>(null)

    var users: MutableLiveData<List<Result>> =
        MutableLiveData(null)


    fun getUsers() {
        GlobalScope.launch {
            val res = UserRepository.getUser()
            launch(Dispatchers.Main) {
                users.value = res.results
            }
        }
    }

    fun setCurrentUser(user: Result?){
        selectedUser.value = user
    }
}
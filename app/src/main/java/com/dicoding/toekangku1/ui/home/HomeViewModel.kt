package com.dicoding.toekangku1.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.dicoding.toekangku1.UserRepository
import com.dicoding.toekangku1.data.dataworkerlocal.UserData

class HomeViewModel (
    private val repository: UserRepository,
    private val context: Context
) : ViewModel() {
    private val _sessionData = MutableLiveData<Pair<String?, String?>>()
    val sessionData: LiveData<Pair<String?, String?>> = _sessionData


    private var type =""
    fun getSession(token: String, type: String) {
        val sharedPreferences = context.getSharedPreferences("APP_PREFS", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("TOKEN", token)
        val type = sharedPreferences.getString("TYPE", type)
        _sessionData.postValue(Pair(token, type))

    }



}
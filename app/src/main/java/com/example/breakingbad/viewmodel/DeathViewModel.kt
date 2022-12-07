package com.example.breakingbad.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbad.model.Death
import com.example.breakingbad.network.Api
import kotlinx.coroutines.launch
import java.lang.Exception

class DeathViewModel: ViewModel() {

    //LiveData Death api
    private val _deathLiveData = MutableLiveData<List<Death>>()
    val deathLiveData: LiveData<List<Death>> = _deathLiveData

    init {
        getBreakingBadDeath()
    }

    private fun getBreakingBadDeath(){
        viewModelScope.launch {
            try {
                _deathLiveData.value = Api.retrofitService.getDeath()
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}
package com.example.breakingbad.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbad.model.Quote
import com.example.breakingbad.network.Api
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    //LiveData
    private val _quoteLiveData = MutableLiveData<List<Quote>>()
    val quoteLiveData: LiveData<List<Quote>> = _quoteLiveData

    fun getCharacterQuotes(characterName: String) {
        viewModelScope.launch {
            try {

                _quoteLiveData.value = Api.retrofitService.getQuotes(characterName)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
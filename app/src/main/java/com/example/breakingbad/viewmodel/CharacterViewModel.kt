package com.example.breakingbad.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbad.model.Character
import com.example.breakingbad.network.Api
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    //LiveData
    private val _characterLiveData = MutableLiveData<List<Character>>()
    val characterLiveData: LiveData<List<Character>> = _characterLiveData

    init {
        breakingBadCharacter()
    }

    //croatian kotlin for api character
    private fun breakingBadCharacter() {
        viewModelScope.launch {
            try {
                _characterLiveData.value = Api.retrofitService.getCharacters()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
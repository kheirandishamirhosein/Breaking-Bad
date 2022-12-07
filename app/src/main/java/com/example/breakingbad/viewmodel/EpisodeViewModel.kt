package com.example.breakingbad.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbad.model.Episode
import com.example.breakingbad.network.Api
import kotlinx.coroutines.launch

class EpisodeViewModel : ViewModel() {

    //LiveData
    private val _episodeLiveData = MutableLiveData<List<Episode>>()
    val episodeLiveData: LiveData<List<Episode>> = _episodeLiveData

    init {
        getBreakingBadEpisode()
    }

    private fun getBreakingBadEpisode() {
        viewModelScope.launch {
            try {
                _episodeLiveData.value = Api.retrofitService.getEpisodes()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
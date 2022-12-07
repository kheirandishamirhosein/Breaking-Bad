package com.example.breakingbad.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.R
import com.example.breakingbad.adapter.EpisodeListAdapter
import com.example.breakingbad.viewmodel.EpisodeViewModel

class EpisodeFragment : Fragment() {

    private val viewModel: EpisodeViewModel by activityViewModels()
    private lateinit var episodeListAdapter: EpisodeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_episode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerviewEpisode(view)
        observes()
    }

    private fun recyclerviewEpisode(view: View) {
        val recyclerviewEpisode: RecyclerView = view.findViewById(R.id.episode_recyclerview)
        episodeListAdapter = EpisodeListAdapter()
        recyclerviewEpisode.adapter = episodeListAdapter
    }

    private fun observes() {
        viewModel.episodeLiveData.observe(viewLifecycleOwner) {
            episodeListAdapter.setItem(it)
        }
    }


}
package com.example.breakingbad.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.R
import com.example.breakingbad.adapter.DeathListAdapter
import com.example.breakingbad.viewmodel.DeathViewModel

class DeathFragment : Fragment() {

    private val viewModel: DeathViewModel by activityViewModels()
    private lateinit var deathListAdapter: DeathListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_death, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerviewDeath(view)
        observes()
    }

    private fun recyclerviewDeath(view: View) {
        val recyclerviewDeath: RecyclerView = view.findViewById(R.id.death_recyclerview)
        deathListAdapter = DeathListAdapter()
        recyclerviewDeath.adapter = deathListAdapter
    }

    private fun observes() {
        viewModel.deathLiveData.observe(viewLifecycleOwner) {
            deathListAdapter.setItem(it)
        }
    }

}
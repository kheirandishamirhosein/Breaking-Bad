package com.example.breakingbad.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.R
import com.example.breakingbad.adapter.CharacterListAdapter
import com.example.breakingbad.viewmodel.CharacterViewModel


class CharacterListFragment : Fragment() {

    //sheared viewModel
    private val viewModel: CharacterViewModel by activityViewModels()

    private lateinit var characterListAdapter: CharacterListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerviewCharacter(view)
        observes()
    }

    private fun recyclerviewCharacter(view: View) {
        val recyclerviewCharacter: RecyclerView = view.findViewById(R.id.character_recyclerview)
        characterListAdapter = CharacterListAdapter()
        recyclerviewCharacter.adapter = characterListAdapter
    }

    private fun observes() {
        viewModel.characterLiveData.observe(viewLifecycleOwner) {
            characterListAdapter.setItem(it)
        }
    }


}
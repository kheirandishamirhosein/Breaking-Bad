package com.example.breakingbad.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.R
import com.example.breakingbad.adapter.QuoteListAdapter
import com.example.breakingbad.databinding.FragmentDetailBinding
import com.example.breakingbad.viewmodel.DetailViewModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by activityViewModels()
    private lateinit var quoteListAdapter: QuoteListAdapter
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerviewQuotes(view)
        observes()
        val characterName = args.characterName
        viewModel.getCharacterQuotes(characterName)
    }

    private fun recyclerviewQuotes(view: View) {
        val recyclerviewQuotes: RecyclerView = view.findViewById(R.id.quote_recyclerview)
        quoteListAdapter = QuoteListAdapter()
        recyclerviewQuotes.adapter = quoteListAdapter
    }

    private fun observes() {
        viewModel.quoteLiveData.observe(viewLifecycleOwner) {
            quoteListAdapter.setItem(it)
        }
    }
}
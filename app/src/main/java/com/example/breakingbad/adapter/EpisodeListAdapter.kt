package com.example.breakingbad.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.R
import com.example.breakingbad.model.Episode

class EpisodeListAdapter : RecyclerView.Adapter<EpisodeListAdapter.EpisodeViewHolder>() {

    private var itemEpisodeList = emptyList<Episode>()

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(itemList: List<Episode>) {
        this.itemEpisodeList = itemList
        notifyDataSetChanged()
    }

    class EpisodeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle: TextView = view.findViewById(R.id.title)
        private val tvSeason: TextView = view.findViewById(R.id.season)
        private val tvAirDate: TextView = view.findViewById(R.id.air_date)
        private val tvCharacters: TextView = view.findViewById(R.id.characters)

        //functions for bind all value Episode data class

        //bind title
        fun bindTitle(titleEpisode: Episode) {
            tvTitle.text = titleEpisode.title
        }

        //bind season
        fun bindSeason(seasonEpisode: Episode) {
            tvSeason.text = seasonEpisode.season
        }

        //bind air_date
        fun airDate(airDateEpisode: Episode) {
            tvAirDate.text = airDateEpisode.air_date
        }

        //bind characters
        fun bindCharacters(charactersEpisode: Episode) {
            tvCharacters.text = charactersEpisode.characters.contentToString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.episode_list_view, parent, false)
        return EpisodeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val item = itemEpisodeList[position]
        holder.bindTitle(item)
        holder.bindSeason(item)
        holder.airDate(item)
        holder.bindCharacters(item)
    }

    override fun getItemCount(): Int {
        return itemEpisodeList.size
    }

}

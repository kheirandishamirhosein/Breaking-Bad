package com.example.breakingbad.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.R
import com.example.breakingbad.model.Death

class DeathListAdapter : RecyclerView.Adapter<DeathListAdapter.DeathViewHolder>() {

    private var itemDeathList = emptyList<Death>()

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(itemList: List<Death>) {
        this.itemDeathList = itemList
        notifyDataSetChanged()
    }

    class DeathViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvDeath: TextView = view.findViewById(R.id.death)
        private val tvCause: TextView = view.findViewById(R.id.cause)
        private val tvResponsible: TextView = view.findViewById(R.id.responsible)
        private val tvLastWords: TextView = view.findViewById(R.id.last_words)
        private val tvSeasonDeath: TextView = view.findViewById(R.id.season_death)
        private val tvEpisodeDeath: TextView = view.findViewById(R.id.episode_death)
        private val tvNumberOfDeaths: TextView = view.findViewById(R.id.number_of_deaths)


        fun deathBind(death: Death) {
            tvDeath.text = death.death
        }

        fun causeBind(cause: Death) {
            tvCause.text = cause.cause
        }

        fun responsibleBind(responsible: Death) {
            tvResponsible.text = responsible.responsible
        }

        fun lastWordsBind(lastWords: Death) {
            tvLastWords.text = lastWords.last_words
        }

        fun seasonDeathBind(seasonDeath: Death) {
            tvSeasonDeath.text = seasonDeath.season_death
        }

        fun episodeDeathBind(episodeDeath: Death) {
            tvEpisodeDeath.text = episodeDeath.episode_death
        }

        fun numberOfDeathsBind(numberOfDeaths: Death) {
            tvNumberOfDeaths.text = numberOfDeaths.number_of_deaths
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeathViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.deaths_list_view, parent, false)
        return DeathViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeathViewHolder, position: Int) {
        val item = itemDeathList[position]
        holder.deathBind(item)
        holder.causeBind(item)
        holder.responsibleBind(item)
        holder.lastWordsBind(item)
        holder.seasonDeathBind(item)
        holder.episodeDeathBind(item)
        holder.numberOfDeathsBind(item)
    }

    override fun getItemCount(): Int {
        return itemDeathList.size
    }
}
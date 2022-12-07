package com.example.breakingbad.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import com.example.breakingbad.R
import com.example.breakingbad.fragments.CharacterListFragmentDirections
import com.example.breakingbad.model.Character

class CharacterListAdapter : RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder>() {

    private var itemCharacterList = emptyList<Character>()

    //set item for live data
    @SuppressLint("NotifyDataSetChanged")
    fun setItem(itemList: List<Character>) {
        this.itemCharacterList = itemList
        notifyDataSetChanged()
    }


    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvCharacterName: TextView = view.findViewById(R.id.textView_CharacterName)
        private val ivCharacterImage: ImageView = view.findViewById(R.id.imageView_Avatar)

        fun bindName(nameCharacter: Character) {
            tvCharacterName.text = nameCharacter.name
        }

        fun bindImage(imageCharacter: Character) {

            //coil
            val getImage = imageCharacter.image
            ivCharacterImage.load(getImage) {
                placeholder(R.drawable.loading)
                memoryCachePolicy(CachePolicy.DISABLED)
                diskCachePolicy(CachePolicy.ENABLED).build()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_list_view, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = itemCharacterList[position]
        holder.bindName(item)
        holder.bindImage(item)
        holder.itemView.setOnClickListener {
            val characterName = item.name
            val action = CharacterListFragmentDirections.detailAction(characterName)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return itemCharacterList.size
    }
}
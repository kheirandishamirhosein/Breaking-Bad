package com.example.breakingbad.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.R
import com.example.breakingbad.model.Quote


class QuoteListAdapter : RecyclerView.Adapter<QuoteListAdapter.QuoteViewHolder>() {

    private var itemQuoteList = emptyList<Quote>()

    //set item for live data(quote)
    @SuppressLint("NotifyDataSetChanged")
    fun setItem(itemList: List<Quote>) {
        this.itemQuoteList = itemList
        notifyDataSetChanged()
    }

    class QuoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvQuote: TextView = view.findViewById(R.id.quote)
        private val tvAuthor: TextView = view.findViewById(R.id.author)

        fun quoteBind(quotesQuote: Quote) {
            tvQuote.text = quotesQuote.quote
        }

        fun authorBind(authorQuote: Quote) {
            tvAuthor.text = authorQuote.author
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.quote_list_view, parent, false)
        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val item = itemQuoteList[position]
        holder.quoteBind(item)
        holder.authorBind(item)
    }

    override fun getItemCount(): Int {
        return itemQuoteList.size
    }
}
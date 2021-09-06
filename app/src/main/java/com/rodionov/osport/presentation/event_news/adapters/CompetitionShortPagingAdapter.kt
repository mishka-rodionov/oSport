package com.rodionov.osport.presentation.event_news.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rodionov.osport.R
import com.rodionov.osport.databinding.ItemCompetitionShortBinding
import com.rodionov.osport.domain.model.CompetitionShort

class CompetitionShortPagingAdapter: PagingDataAdapter<CompetitionShort, RecyclerView.ViewHolder>(COMPETITION_SHORT_COMPARATOR) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("LOG_TAG", "onBindViewHolder: ")
        getItem(position)?.let { (holder as CompetitionShortViewHolder).bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("LOG_TAG", "onCreateViewHolder: ")
        return CompetitionShortViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_competition_short, parent, false)
        )
    }

    inner class CompetitionShortViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val binding = ItemCompetitionShortBinding.bind(itemView)

        fun bind(competitionShort: CompetitionShort) {
            binding.tvCompetitionShortDate.text = competitionShort.date
            binding.tvCompetitionShortTime.text = competitionShort.time
            binding.tvCompetitionShortTitle.text = competitionShort.title
        }

    }

    companion object {
        private val COMPETITION_SHORT_COMPARATOR = object : DiffUtil.ItemCallback<CompetitionShort>() {
            override fun areItemsTheSame(oldItem: CompetitionShort, newItem: CompetitionShort): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CompetitionShort, newItem: CompetitionShort): Boolean =
                oldItem == newItem
        }
    }

}
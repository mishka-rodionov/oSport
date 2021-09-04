package com.rodionov.osport.presentation.event_news.adapters

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rodionov.osport.domain.model.CompetitionShort

class CompetitionShortPagingAdapter: PagingDataAdapter<CompetitionShort, RecyclerView.ViewHolder>(COMPETITION_SHORT_COMPARATOR) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    }

    inner class CompetitionShortViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(competitionShort: CompetitionShort) {

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
package com.kumastudio.capstoneproject.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kumastudio.capstoneproject.core.R
import com.kumastudio.capstoneproject.core.databinding.ItemListMovieBinding
import com.kumastudio.capstoneproject.core.domain.model.MovieData

class MovieDataAdapter : RecyclerView.Adapter<MovieDataAdapter.ListViewHolder>() {

    private var listData = ArrayList<MovieData>()
    var onItemClick: ((MovieData) -> Unit)? = null

    fun setData(newListData: List<MovieData>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMovieBinding.bind(itemView)
        fun bind(data: MovieData) {
            with(binding) {
                Glide.with(itemView.context)
                        .load(data.image)
                        .into(ivItemImage)
                tvItemTitle.text = data.name
                tvItemDesc.text = data.description
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}
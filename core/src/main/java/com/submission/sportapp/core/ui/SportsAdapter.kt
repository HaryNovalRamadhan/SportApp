package com.submission.sportapp.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.submission.sportapp.core.R
import com.submission.sportapp.core.databinding.SportsItemListBinding
import com.submission.sportapp.core.domain.model.Sports

class SportsAdapter: RecyclerView.Adapter<SportsAdapter.ListViewHolder>() {

    private var listData = ArrayList<Sports>()
    var onItemClick: ((Sports) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<Sports>?){
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sports_item_list, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = SportsItemListBinding.bind(itemView)
        fun bind(data: Sports){
            with(binding){
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(ivItemImage)
                tvItemTitle.text = data.name
                tvItemSubtitle.text = data.sportsFormat
            }
        }

        init {
            binding.root.setOnClickListener{
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}
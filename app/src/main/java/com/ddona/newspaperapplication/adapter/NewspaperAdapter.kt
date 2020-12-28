package com.ddona.newspaperapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ddona.newspaperapplication.model.ItemData
import com.ddona.newspaperapplication.databinding.NewspaperItemBinding

class NewspaperAdapter : RecyclerView.Adapter<NewspaperAdapter.NewspaperHolder> {
    private val inter: INewAdapter

    constructor(inter: INewAdapter) {
        this.inter = inter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewspaperHolder {
        return NewspaperHolder(
            NewspaperItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewspaperHolder, position: Int) {
        holder.binding.data = inter.getData(position)
        holder.itemView.setOnClickListener {
            inter.onClickDetail(holder.adapterPosition)
        }
    }

    override fun getItemCount() = inter.getCount()

    interface INewAdapter {
        fun onClickDetail(position: Int)
        fun getCount(): Int
        fun getData(position: Int): ItemData
    }

    class NewspaperHolder(val binding: NewspaperItemBinding) : RecyclerView.ViewHolder(binding.root)
}
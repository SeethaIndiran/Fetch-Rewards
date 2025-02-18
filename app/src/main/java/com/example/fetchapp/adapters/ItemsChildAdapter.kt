package com.example.fetchapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchapp.databinding.ItemChildBinding
import com.example.fetchapp.models.Item

class ItemsChildAdapter: RecyclerView.Adapter<ItemsChildAdapter.ChildViewHolder>()  {

    private var binding: ItemChildBinding? = null

    inner class ChildViewHolder(itemBinding: ItemChildBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object :
        DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        binding = ItemChildBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChildViewHolder(binding!!)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {

        val childItem = differ.currentList[position]

        holder.itemView.apply {

            binding?.tvItemId?.text = "id: ${childItem.id}"
            binding?.tvItemName?.text = "name ${childItem.name}"


        }



    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}
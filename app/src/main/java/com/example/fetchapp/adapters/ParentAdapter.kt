package com.example.fetchapp.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchapp.databinding.ItemParentBinding
import com.example.fetchapp.models.ParentItem

class ParentAdapter : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<ParentItem>() {
        override fun areItemsTheSame(oldItem: ParentItem, newItem: ParentItem): Boolean {
            return oldItem.listId == newItem.listId
        }

        override fun areContentsTheSame(oldItem: ParentItem, newItem: ParentItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class ParentViewHolder(private val binding: ItemParentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val childAdapter = ItemsChildAdapter()

        init {
            binding.rvItems.apply {
                adapter = childAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
            }

            binding.parentLayout.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val updatedList = differ.currentList.toMutableList()
                    val item = updatedList[position].copy(isExpandable = !updatedList[position].isExpandable)
                    updatedList[position] = item
                    differ.submitList(updatedList)
                }
            }
        }

        fun bind(item: ParentItem) {
            binding.tvListId.text = "List: ${item.listId}"
            binding.expandableLayout.visibility = if (item.isExpandable) View.VISIBLE else View.GONE
            binding.divider.visibility = if (item.isExpandable) View.INVISIBLE else View.VISIBLE

            // Submit child items to the child adapter
            childAdapter.differ.submitList(item.itemsList)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val binding = ItemParentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

}

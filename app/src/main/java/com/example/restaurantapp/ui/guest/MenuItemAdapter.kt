package com.example.restaurantapp.ui.guest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.databinding.ComponentMenuItemCardBinding
import com.example.restaurantapp.model.MenuItem

class MenuItemAdapter(
    private val onItemClick: (MenuItem) -> Unit,
    private val onDeleteClick: ((MenuItem, Int) -> Unit)? = null
) : ListAdapter<MenuItem, MenuItemAdapter.MenuItemViewHolder>(MenuItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val binding = ComponentMenuItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MenuItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class MenuItemViewHolder(
        private val binding: ComponentMenuItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MenuItem, position: Int) {
            binding.tvItemName.text = item.name
            binding.tvItemPrice.text = "RM ${String.format("%.2f", item.price)}"
            binding.tvItemDescription.text = item.description
            binding.ivItemImage.setImageResource(item.imageResId)
            binding.btnAction.visibility = ViewGroup.GONE

            // Show/hide delete icon based on whether delete callback is provided
            if (onDeleteClick != null) {
                binding.ivDelete.visibility = ViewGroup.VISIBLE
                binding.ivDelete.setOnClickListener {
                    onDeleteClick(item, position)
                }
            } else {
                binding.ivDelete.visibility = ViewGroup.GONE
            }

            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    private class MenuItemDiffCallback : DiffUtil.ItemCallback<MenuItem>() {
        override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem == newItem
        }
    }
}


package com.budakattusante.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.budakattusante.data.db.entity.Product
import com.budakattusante.databinding.ItemManageProductBinding

/**
 * RecyclerView adapter for the Manage Products screen.
 * Each item shows product name, price, stock, with Edit and Delete buttons.
 * Also reused in AnalyticsFragment for low-stock list (buttons are no-ops).
 */
class ManageProductAdapter(
    private val onEdit: (Product) -> Unit,
    private val onDelete: (Product) -> Unit
) : ListAdapter<Product, ManageProductAdapter.ManageViewHolder>(ManageProductDiffCallback()) {

    inner class ManageViewHolder(private val binding: ItemManageProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.tvProductName.text  = product.name
            binding.tvPrice.text        = "₹${product.price.toLong()}"
            binding.tvStock.text        = "Stock: ${product.stock}"
            binding.tvEmoji.text        = categoryEmoji(product.category)
            binding.tvEmoji.setBackgroundColor(categoryColor(product.category))

            // Highlight low stock in red
            if (product.stock < 10) {
                binding.tvStock.setTextColor(Color.parseColor("#B00020"))
            } else {
                binding.tvStock.setTextColor(Color.parseColor("#757575"))
            }

            binding.btnEdit.setOnClickListener   { onEdit(product) }
            binding.btnDelete.setOnClickListener { onDelete(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManageViewHolder {
        val binding = ItemManageProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ManageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ManageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun categoryEmoji(category: String): String = when (category) {
        "Forest Produce"  -> "🌿"
        "Handicrafts"     -> "🧺"
        "Herbal Products" -> "🌱"
        "Grains & Seeds"  -> "🌾"
        "Honey & Sweets"  -> "🍯"
        else              -> "🍃"
    }

    private fun categoryColor(category: String): Int = when (category) {
        "Forest Produce"  -> Color.parseColor("#C8E6C9")
        "Handicrafts"     -> Color.parseColor("#D7CCC8")
        "Herbal Products" -> Color.parseColor("#BBDEFB")
        "Grains & Seeds"  -> Color.parseColor("#FFE0B2")
        "Honey & Sweets"  -> Color.parseColor("#FFF9C4")
        else              -> Color.parseColor("#E8F5E9")
    }

    class ManageProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
    }
}

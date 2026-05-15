package com.budakattusante.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.budakattusante.data.db.entity.Product
import com.budakattusante.databinding.ItemProductBinding

/**
 * RecyclerView adapter for displaying product cards.
 * Uses DiffUtil for efficient list updates.
 * Each card shows category-based background color and emoji.
 */
class ProductAdapter(
    private val onProductClick: (Product) -> Unit
) : ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.tvProductName.text  = product.name
            binding.tvVillage.text      = "🏕️ ${product.village}"
            binding.tvPrice.text        = "₹${product.price.toLong()}"
            binding.tvCategoryEmoji.text = categoryEmoji(product.category)

            // Category-based background color
            binding.productImageArea.setBackgroundColor(categoryColor(product.category))

            // Stock badge
            if (product.stock > 0) {
                binding.tvStockBadge.text = "In Stock"
                binding.tvStockBadge.setBackgroundColor(Color.parseColor("#2E7D32"))
            } else {
                binding.tvStockBadge.text = "Sold Out"
                binding.tvStockBadge.setBackgroundColor(Color.parseColor("#B00020"))
            }

            // Navigate to product detail on card click
            binding.productCard.setOnClickListener { onProductClick(product) }
            binding.btnPreorder.setOnClickListener { onProductClick(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // ---- Helpers ----

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

    class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
    }
}

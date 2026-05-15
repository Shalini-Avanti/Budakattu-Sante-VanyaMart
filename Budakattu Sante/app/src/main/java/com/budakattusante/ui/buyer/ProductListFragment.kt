package com.budakattusante.ui.buyer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.budakattusante.R
import com.budakattusante.databinding.FragmentProductListBinding
import com.budakattusante.ui.adapter.ProductAdapter
import com.budakattusante.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Full product browser with search bar and category filter chips.
 * Tapping a product navigates to ProductDetailFragment.
 */
@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private val productViewModel: ProductViewModel by activityViewModels()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupSearch()
        setupCategoryChips()
        observeProducts()

        // Load all products on first open
        productViewModel.showAll()
    }

    private fun setupRecyclerView() {
        productAdapter = ProductAdapter { product ->
            val bundle = Bundle().apply { putInt("productId", product.id) }
            findNavController().navigate(R.id.action_list_to_productDetail, bundle)
        }
        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
        }
    }

    private fun setupSearch() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                if (query.isEmpty()) {
                    productViewModel.showAll()
                } else {
                    productViewModel.searchProducts(query)
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun setupCategoryChips() {
        binding.chipAll.setOnCheckedChangeListener { _, checked ->
            if (checked) productViewModel.showAll()
        }
        binding.chipForest.setOnCheckedChangeListener { _, checked ->
            if (checked) productViewModel.filterByCategory("Forest Produce")
        }
        binding.chipHandicraft.setOnCheckedChangeListener { _, checked ->
            if (checked) productViewModel.filterByCategory("Handicrafts")
        }
        binding.chipHerbal.setOnCheckedChangeListener { _, checked ->
            if (checked) productViewModel.filterByCategory("Herbal Products")
        }
        binding.chipGrains.setOnCheckedChangeListener { _, checked ->
            if (checked) productViewModel.filterByCategory("Grains & Seeds")
        }
        binding.chipHoney.setOnCheckedChangeListener { _, checked ->
            if (checked) productViewModel.filterByCategory("Honey & Sweets")
        }
    }

    private fun observeProducts() {
        productViewModel.filteredProducts.observe(viewLifecycleOwner) { products ->
            productAdapter.submitList(products)
            binding.tvEmpty.visibility = if (products.isEmpty()) View.VISIBLE else View.GONE
        }

        productViewModel.allProducts.observe(viewLifecycleOwner) { products ->
            // Only use allProducts if filteredProducts has not been set yet
            if (productViewModel.filteredProducts.value == null) {
                productAdapter.submitList(products)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

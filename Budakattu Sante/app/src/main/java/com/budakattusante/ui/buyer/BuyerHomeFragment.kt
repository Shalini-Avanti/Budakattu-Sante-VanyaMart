package com.budakattusante.ui.buyer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.budakattusante.R
import com.budakattusante.data.db.entity.Product
import com.budakattusante.data.preferences.SessionManager
import com.budakattusante.databinding.FragmentBuyerHomeBinding
import com.budakattusante.ui.adapter.ProductAdapter
import com.budakattusante.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Buyer home screen.
 * Shows greeting, category filter chips, and all products in a list.
 * Tapping the search bar navigates to ProductListFragment.
 * Tapping a product navigates to ProductDetailFragment.
 */
@AndroidEntryPoint
class BuyerHomeFragment : Fragment() {

    private var _binding: FragmentBuyerHomeBinding? = null
    private val binding get() = _binding!!

    private val productViewModel: ProductViewModel by activityViewModels()
    private lateinit var productAdapter: ProductAdapter

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuyerHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupGreeting()
        setupRecyclerView()
        setupCategoryChips()
        setupClickListeners()
        observeProducts()
    }

    private fun setupGreeting() {
        val name = sessionManager.getUserName()
        binding.tvUserName.text = "Welcome, $name"
    }

    private fun setupRecyclerView() {
        productAdapter = ProductAdapter { product ->
            navigateToDetail(product.id)
        }
        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
        }
    }

    private fun setupCategoryChips() {
        binding.chipAll.setOnClickListener { productViewModel.showAll() }
        binding.chipForest.setOnClickListener { productViewModel.filterByCategory("Forest Produce") }
        binding.chipHandicraft.setOnClickListener { productViewModel.filterByCategory("Handicrafts") }
        binding.chipHerbal.setOnClickListener { productViewModel.filterByCategory("Herbal Products") }
        binding.chipGrains.setOnClickListener { productViewModel.filterByCategory("Grains & Seeds") }
        binding.chipHoney.setOnClickListener { productViewModel.filterByCategory("Honey & Sweets") }
    }

    private fun setupClickListeners() {
        // Tapping search bar goes to product list with search focus
        binding.searchBar.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_productList)
        }

        binding.tvBrowseAll.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_productList)
        }
    }

    private fun observeProducts() {
        // Show allProducts initially; filteredProducts when chip selected
        productViewModel.allProducts.observe(viewLifecycleOwner) { products ->
            productAdapter.submitList(products)
        }

        productViewModel.filteredProducts.observe(viewLifecycleOwner) { products ->
            productAdapter.submitList(products)
        }
    }

    private fun navigateToDetail(productId: Int) {
        val bundle = Bundle().apply { putInt("productId", productId) }
        findNavController().navigate(R.id.action_home_to_productDetail, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

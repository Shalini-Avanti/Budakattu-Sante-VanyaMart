package com.budakattusante.ui.leader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.budakattusante.databinding.FragmentAnalyticsBinding
import com.budakattusante.ui.adapter.ManageProductAdapter
import com.budakattusante.ui.viewmodel.OrderViewModel
import com.budakattusante.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Analytics screen for Cooperative Leader.
 * Shows:
 * - Total product count
 * - Total order count
 * - Total earnings
 * - Low stock alerts (products with < 10 units)
 */
@AndroidEntryPoint
class AnalyticsFragment : Fragment() {

    private var _binding: FragmentAnalyticsBinding? = null
    private val binding get() = _binding!!

    private val orderViewModel: OrderViewModel by activityViewModels()
    private val productViewModel: ProductViewModel by activityViewModels()
    private lateinit var lowStockAdapter: ManageProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnalyticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupLowStockRecycler()
        observeAnalytics()

        orderViewModel.loadAnalytics()
    }

    private fun setupLowStockRecycler() {
        // Re-use ManageProductAdapter in read-only mode (no edit/delete actions needed)
        lowStockAdapter = ManageProductAdapter(
            onEdit   = { /* no-op in analytics view */ },
            onDelete = { /* no-op in analytics view */ }
        )
        binding.rvLowStock.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = lowStockAdapter
        }
    }

    private fun observeAnalytics() {
        orderViewModel.productCount.observe(viewLifecycleOwner) { count ->
            binding.tvProductCount.text = count.toString()
        }
        orderViewModel.orderCount.observe(viewLifecycleOwner) { count ->
            binding.tvOrderCount.text = count.toString()
        }
        orderViewModel.totalEarnings.observe(viewLifecycleOwner) { amount ->
            binding.tvTotalEarnings.text = "₹${String.format("%.0f", amount)}"
        }

        productViewModel.lowStockProducts.observe(viewLifecycleOwner) { products ->
            lowStockAdapter.submitList(products)
            if (products.isEmpty()) {
                binding.rvLowStock.visibility    = View.GONE
                binding.tvNoLowStock.visibility  = View.VISIBLE
            } else {
                binding.rvLowStock.visibility    = View.VISIBLE
                binding.tvNoLowStock.visibility  = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
